import request from '@/utils/request'

// 查询文件信息列表
export function listFileInfo(query) {
  return request({
    url: '/easystudy/fileInfo/list',
    method: 'get',
    params: query
  })
}

// 查询文件信息详细
export function getFileInfo(fileId) {
  return request({
    url: '/easystudy/fileInfo/' + fileId,
    method: 'get'
  })
}

// 新增文件信息
export function addFileInfo(data) {
  return request({
    url: '/easystudy/fileInfo',
    method: 'post',
    data: data
  })
}

// 修改文件信息
export function updateFileInfo(data) {
  return request({
    url: '/easystudy/fileInfo',
    method: 'put',
    data: data
  })
}

// 删除文件信息
export function delFileInfo(fileId) {
  return request({
    url: '/easystudy/fileInfo/' + fileId,
    method: 'delete'
  })
}
