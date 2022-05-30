<template>
  <div class='wind-main'>
    <div class='data-search'>

    </div>
    <div class='data-table'>
      <el-table :data='accountList'>
        <el-table-column prop='wxNickName' label='微信昵称' width='100' />
        <el-table-column label='微信头像' width='80'>
          <template v-slot:default='{row}'>
            <img :src='row.wxAvatar' height='50' width='50' alt='' />
          </template>
        </el-table-column>
        <el-table-column prop='loginDate' label='最近登录时间' width='180' />
        <el-table-column prop='loginIp' label='最近登录ip' width='130' />
        <el-table-column prop='registerDate' label='注册时间' width='180' />
        <el-table-column prop='registerIp' label='注册ip' width='130'/>
        <el-table-column prop='accountStatusText' label='账号状态'></el-table-column>
        <el-table-column fixed="right" label="操作" width="300">
          <template #default='{row}'>
            <el-button type="text" size="small" v-if='row.userId'>用户详情</el-button>
            <el-button type="text" size="small" v-else>绑定用户</el-button>
            <el-button type='text' size='small'>删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script lang='ts' setup>
import { onMounted, reactive } from 'vue';
import { WxAccount } from '@/views/MainMenu/UserMenu/WxUser/WxUser';
import { apiMethod } from '@/config/api_config/apis';

let accountList: WxAccount[] = reactive([]);
onMounted(async () => {
  let res = await apiMethod.getWxAccountList({ pageIndex: 1, pageLimit: 10 });
  accountList.push(...res.result);
});
</script>
<style lang='scss' scoped>
</style>
