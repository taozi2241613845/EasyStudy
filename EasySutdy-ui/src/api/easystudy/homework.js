import request from '@/utils/request'

// 查询作业列表
export function listHomework(query) {
  return request({
    url: '/easystudy/homework/list',
    method: 'get',
    params: query
  })
}

// 查询作业详细
export function getHomework(id) {
  return request({
    url: '/easystudy/homework/' + id,
    method: 'get'
  })
}

// 新增作业
export function addHomework(data) {
  return request({
    url: '/easystudy/homework',
    method: 'post',
    data: data
  })
}

// 修改作业
export function updateHomework(data) {
  return request({
    url: '/easystudy/homework',
    method: 'put',
    data: data
  })
}

// 删除作业
export function delHomework(id) {
  return request({
    url: '/easystudy/homework/' + id,
    method: 'delete'
  })
}
