import request from '@/utils/request'

// 查询作业题目列表
export function listHomeworkQuestion(query) {
  return request({
    url: '/easystudy/homeworkQuestion/list',
    method: 'get',
    params: query
  })
}

// 查询作业题目详细
export function getHomeworkkQuestion(id) {
  return request({
    url: '/easystudy/homeworkQuestion/' + id,
    method: 'get'
  })
}

// 新增作业题目
export function addHomeworkkQuestion(data) {
  return request({
    url: '/easystudy/homeworkQuestion',
    method: 'post',
    data: data
  })
}

// 修改作业题目
export function updateHomeworkkQuestion(data) {
  return request({
    url: '/easystudy/homeworkQuestion',
    method: 'put',
    data: data
  })
}

// 删除作业题目
export function delHomework(id) {
  return request({
    url: '/easystudy/homework/' + id,
    method: 'delete'
  })
}
