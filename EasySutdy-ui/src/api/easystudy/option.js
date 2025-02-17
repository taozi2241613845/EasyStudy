import request from '@/utils/request'

// 查询选择题选项列表
export function listOption(query) {
  return request({
    url: '/easystudy/option/list',
    method: 'get',
    params: query
  })
}

// 查询选择题选项详细
export function getOption(optionId) {
  return request({
    url: '/easystudy/option/' + optionId,
    method: 'get'
  })
}

// 新增选择题选项
export function addOption(data) {
  return request({
    url: '/easystudy/option',
    method: 'post',
    data: data
  })
}

// 修改选择题选项
export function updateOption(data) {
  return request({
    url: '/easystudy/option',
    method: 'put',
    data: data
  })
}

// 删除选择题选项
export function delOption(optionId) {
  return request({
    url: '/easystudy/option/' + optionId,
    method: 'delete'
  })
}
