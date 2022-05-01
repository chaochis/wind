<template>
  <div>
    {{dataList}}
  </div>
</template>
<script lang='ts' setup>
import { onMounted, reactive } from 'vue';
import { WxAccount } from '@/views/MainMenu/UserMenu/WxUser/WxUser';
import { apiMethod } from '@/config/api_config/apis';

let dataList: WxAccount[]
onMounted(async () => {
  let res = await apiMethod.getWxAccountList({accountName: "22", pageIndex: 1, pageLimit: 10})
})
</script>
