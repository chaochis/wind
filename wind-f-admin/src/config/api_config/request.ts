
import axios, { AxiosInstance } from 'axios';
import qs from 'qs';

/**
 * 对外发起请求的axios对象
 */
const adminRequest: AxiosInstance = axios.create({
  baseURL: "http://localhost:8089",
  timeout: 60000,
  paramsSerializer: (params) => qs.stringify(params, { arrayFormat: 'indices' }),
});

/**
 * 发起请求时修改header请求头
 */
adminRequest.interceptors.request.use((config) => {
  return config;
}, (error) => {
  return error;
});

/**
 * 统一处理ajax请求返回的结果
 */
adminRequest.interceptors.response.use((config) => {
  if (config.headers['content-type'] === 'application/json') {
    return config;
  }
  return config;
}, ((error) => {
  return error;
}));

export const request = adminRequest;
