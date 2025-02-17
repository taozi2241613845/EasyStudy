import request from '@/utils/request'

// 查询课程列表
export function listCourse(query) {
  return request({
    url: '/easystudy/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程列表，不分页
export function listAllCourse() {
  return request({
    url: '/easystudy/course/list/all',
    method: 'get',
    params: null
  })
}

// 查询课程详细
export function getCourse(id) {
  return request({
    url: '/easystudy/course/' + id,
    method: 'get'
  })
}

// 新增课程
export function addCourse(data) {
  return request({
    url: '/easystudy/course',
    method: 'post',
    data: data
  })
}

// 修改课程
export function updateCourse(data) {
  return request({
    url: '/easystudy/course',
    method: 'put',
    data: data
  })
}

// 删除课程
export function delCourse(id) {
  return request({
    url: '/easystudy/course/' + id,
    method: 'delete'
  })
}
