<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="难度" prop="difficulty">
        <el-input
          v-model="queryParams.difficulty"
          placeholder="难度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程名称" prop="courseId">
        <el-input
          v-model="queryParams.courseId"
          placeholder="请输入题目对应的课程id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['easystudy:question:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['easystudy:question:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['easystudy:question:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['easystudy:question:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="questionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="题目类型" align="center" prop="typeName" />
      <el-table-column label="题干" align="center" prop="content" />
      <el-table-column label="答案" align="center" prop="answer" >
        <template slot-scope="scope">
            {{getFormattedAnswerLabel(scope.row.type,scope.row.answer)}}
        </template>
      </el-table-column>
      <el-table-column label="难度" align="center" prop="difficulty" >
         <template slot-scope="scope">
            {{difficultyReverseDict[scope.row.difficulty]}}
         </template>
      </el-table-column>
      <el-table-column label="课程名称" align="center" prop="courseName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['easystudy:question:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['easystudy:question:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改题目对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="550px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="题型" required>
          <el-radio-group v-model="form.type" @change="questionTypeChange">
            <el-radio-button v-for="entry in Object.entries(questionTypeDict)"  :key="entry[1]"  :label="entry[1]">{{entry[0]}}</el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="题干" required>
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="答案" prop="answer" >
          <el-radio-group v-model="form.answer" v-if="form.type==questionTypeDict['单选题']">
            <el-radio-button v-for="entry in Object.entries(choiceQuestionAnswer)" :key="entry[0]" :label="entry[1]">{{entry[0]}}</el-radio-button>
          </el-radio-group>
          <el-radio-group v-model="form.answer"  v-if="form.type==questionTypeDict['判断题']">
            <el-radio-button v-for="entry in Object.entries(trueOrFalseQuestionAnswer)" :key="entry[0]" :label="entry[0]">{{entry[1]}}</el-radio-button>
          </el-radio-group>
          <el-checkbox-group v-model="mutipleChoiceAnswer" v-if="form.type==questionTypeDict['多选题']">
            <el-checkbox-button v-for="entry in Object.entries(choiceQuestionAnswer)" :key="entry[0]" :label="entry[1]">{{entry[0]}}</el-checkbox-button>
          </el-checkbox-group>
          <el-input v-model="form.answer" placeholder="请输入答案" v-if="form.type==questionTypeDict['填空题']" />
          <editor v-model="form.answer" :min-height="192" v-if="form.type==questionTypeDict['简答题']" />
          
        </el-form-item>
        <el-form-item label="难度" prop="difficulty" required>
          <el-radio-group v-model="form.difficulty">
            <el-radio-button v-for="entry in Object.entries(difficultyDict)" :key="entry[0]" :label="entry[1]" >{{entry[0]}}</el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="课程" prop="courseId" required>
          <el-select v-model="form.courseId" placeholder="请选择">
            <el-option
              v-for="course in courses"
              :key="course.id"
              :label="course.name"
              :value="course.id">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {getQuestionAnswerLabel} from '@/utils/easystudy.js'
import { listQuestion, getQuestion, delQuestion, addQuestion, updateQuestion } from "@/api/easystudy/question";
import {questionTypeDict,difficultyDict,difficultyReverseDict
  ,trueOrFalseQuestionAnswer,trueOrFalseReverseQuestionAnswer
  ,choiceQuestionAnswer,choiceQuestionRverseAnswer} from "../../../utils/dictInMemory";
import { listAllCourse } from "../../../api/easystudy/course";
export default {
  name: "Question",
  data() {
    return {
      mutipleChoiceAnswer:[],
      // 遮罩层
      loading: true,
      courses:[],
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 题目表格数据
      questionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      //各种字典
      questionTypeDict:questionTypeDict,
      difficultyDict:difficultyDict,
      difficultyReverseDict:difficultyReverseDict,
      choiceQuestionAnswer:choiceQuestionAnswer,
      choiceQuestionRverseAnswer:choiceQuestionRverseAnswer,
      trueOrFalseQuestionAnswer:trueOrFalseQuestionAnswer,
      trueOrFalseReverseQuestionAnswer:trueOrFalseReverseQuestionAnswer,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        content: null,
        answer: null,
        difficulty: null,
        courseId: null
      },
      // 表单参数
      form: {
        
      },
      // 表单校验
      rules: {
        type: [{ required: true, message: '请选择类型', trigger: 'blur' },],
        content: [{ required: true, message: '请输入题干', trigger: 'blur' },],
        difficulty: [{ required: true, message: '请选择难度', trigger: 'blur' },],
        answer: [{ required: true, message: '答案是必要的', trigger: 'blur' },],
        courseId: [{ required: true, message: '请选择课程', trigger: 'blur' },],
      }
    };
  },
  created() {
    this.getList();
  },
  watch:{
  },
  methods: {
    questionTypeChange(questionType){
      //切换其他题型需要重置表单
        this.reset();
        this.form.type = questionType;
    },
    /** 查询题目列表 */
    getList() {
      this.loading = true;
      listQuestion(this.queryParams).then(response => {
        this.questionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.mutipleChoiceAnswer = [];
      this.form = {
        id: null,
        type: null,
        content: null,
        answer: null,
        difficulty: difficultyDict['简单'],
        courseId: null

      };
      this.resetForm("form");
    },
    formDefaultSet(){
      this.form = {
        id: null,
        type: questionTypeDict['单选题'],
        content: null,
        answer: 'A',
        difficulty: difficultyDict['简单'],
        courseId: null

      };
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      listAllCourse().then(response => {
        this.courses = response.data;
      })
      this.reset();
      //设置默认值
      this.formDefaultSet();
      this.open = true;
      this.title = "添加题目"; 
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      listAllCourse().then(response => {
        this.courses = response.data;
      })
      this.reset();
      const id = row.id || this.ids
      getQuestion(id).then(response => {
        this.form = response.data;
        this.open = true;
        if(this.form.type==questionTypeDict['多选题']){
          this.mutipleChoiceAnswer = this.form.answer.split(',');
        }
        this.title = "修改题目";
      });
    },
    /** 提交按钮 */
    submitForm() {
      //把多选题目的答案转换成统一的格式
      if(this.form.type == questionTypeDict['多选题']){
        this.form.answer = this.mutipleChoiceAnswer.join(',');
      }
      
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateQuestion(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addQuestion(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除题目编号为"' + ids + '"的数据项？').then(function() {
        return delQuestion(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('easystudy/question/export', {
        ...this.queryParams
      }, `question_${new Date().getTime()}.xlsx`)
    },
    getFormattedAnswerLabel(questionType,answer){
      return getQuestionAnswerLabel(questionType,answer);
    }
  }
};
</script>
