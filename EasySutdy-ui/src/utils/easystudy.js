import { questionTypeDict,choiceQuestionAnswer as choiceQuestionAnswer,trueOrFalseQuestionAnswer, } from "./dictInMemory"
export function getQuestionAnswerLabel(questionType,answer){
    if(questionType == questionTypeDict['单选题']){
        return choiceQuestionAnswer[answer];
    }else if(questionType == questionTypeDict['多选题']){
        return answer;
    }else if(questionType == questionTypeDict['判断题']){
        return trueOrFalseQuestionAnswer[answer]
    }else if(questionType == questionTypeDict['填空题']){
        return answer;
    }else if(questionType == questionTypeDict['简答题']){
        return answer;
    }
}

export function formatFileSize(bytes) {
    if (bytes === 0) return '0 B';

    const k = 1024;
    const sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));

    // 使用toFixed(2)保留两位小数，可以根据需要调整
    return (bytes / Math.pow(k, i)).toFixed(2) + ' ' + sizes[i];
}
