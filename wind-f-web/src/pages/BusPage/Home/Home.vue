


<template>
  <div v-loading="loading">
    <el-form ref="cloudForm" :model="docData" :rules="rules" size="mini" label-width="140px">
      <el-row style="" class="web-box">
        <el-form-item label-width="0">
          <div style="font-size:14px;">基本信息</div>
        </el-form-item>
        <el-row>
          <el-col :span="8">
            <el-form-item label="渠道名称" prop="channel_name">
              <el-input v-model="docData.channel_name" size="mini" placeholder="请输入渠道名称" :maxlength="50"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="业务类型" prop="business_type">
              <el-select size="mini" v-model="docData.business_type" placeholder="请选择业务类型" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in business_typeOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否有营业执照" prop="has_license">
              <el-select size="mini" v-model="docData.has_license" placeholder="请选择是否有营业执照" clearable
                         :style="{width: '100%'}" @change="change">
                <el-option v-for="(item, index) in has_licenseOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item v-if="xym" label="社会统一信用代码" prop="SUCC">
              <el-input v-model="docData.SUCC" size="mini" placeholder="请输入社会统一信用代码" :maxlength="18" clearable
                        :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="经营地址" prop="manage_addrOptionsValue">
              <input type="hidden" v-model="docData.manage_addr" value="" hiddennames="" />
              <el-cascader size="mini" :show-all-levels="false" ref="manage_addr"
                           v-model="docData.manage_addrOptionsValue" popper-class="custom-popper-class"
                           :options="manage_addrOptions" @change="changFunction('manage_addr')"
                           @visible-change="(flag)=>visibleChange(flag,'manage_addr')" :props="manage_addrProps"
                           :style="{width: '100%'}" placeholder="请选择经营地址" clearable></el-cascader>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="详细地址" prop="detail_addr">
              <el-input v-model="docData.detail_addr" size="mini" placeholder="请输入详细地址" :maxlength="200"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="门店地址" prop="store_addr">
              <el-input v-model="docData.store_addr" size="mini" placeholder="点击选择门店地址" :maxlength="200"
                        readonly clearable :style="{width: '100%'}" @focus="chooseMaps"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="成立时间" prop="establishment_time">
              <el-date-picker size="mini" :editable="false" v-model="docData.establishment_time"
                              format="yyyy-MM-dd" value-format="yyyy-MM-dd" :style="{width: '100%'}" placeholder="请选择成立时间"
                              clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="渠道维护人" prop="channel_maintainer">
              <el-input v-model="docData.ATTR_channel_maintainer" size="mini" placeholder="请输入渠道维护人" clearable
                        :style="{width: '100%'}">
                <input type="hidden" v-model="docData.channel_maintainer" value="" hiddennames=""
                       data-model="objectInput" class="treeSelectInputHidden">
                <el-button slot="append" icon="el-icon-search"
                           @click="selectTreeField('channel_maintainer','organize','leaf','undefined','false')">
                </el-button>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-row>
      <el-row style="" class="web-box">
        <el-form-item label-width="0">
          <div style="font-size:14px;">负责人信息</div>
        </el-form-item>
        <el-row style="">
          <el-col :span="8">
            <el-form-item label="联系人姓名" prop="contact_name">
              <el-input v-model="docData.contact_name" size="mini" placeholder="请输入联系人姓名" :maxlength="50"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="联系人身份证" prop="contact_idcard">
              <el-input v-model="docData.contact_idcard" size="mini" placeholder="请输入联系人身份证" :maxlength="50"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="联系人电话" prop="contact_tel">
              <el-input v-model="docData.contact_tel" size="mini" placeholder="请输入联系人电话" :maxlength="11"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="备注信息" prop="remark_info">
              <el-input v-model="docData.remark_info" type="textarea" size="mini" placeholder="请输入备注信息"
                        :maxlength="1000" :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-row>
      <el-row style="" class="web-box">
        <el-form-item label-width="0">
          <div style="font-size:14px;">影像信息</div>
        </el-form-item>
        <el-row style="">
          <el-col :span="8">
            <el-form-item label="营业执照" prop="business_license">
              <el-upload ref="business_license" :file-list="business_licensefileList" action="#"
                         :data="business_license" :http-request="fileUpload" :on-preview="downloadFile"
                         :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'business_license')}"
                         list-type="picture-card" accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,business_licensefileList,'business_license')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="渠道门头照片" prop="channel_door_pic">
              <el-upload ref="channel_door_pic" :file-list="channel_door_picfileList" action="#"
                         :data="channel_door_pic" :http-request="fileUpload" :on-preview="downloadFile"
                         :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'channel_door_pic')}"
                         list-type="picture-card" accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,channel_door_picfileList,'channel_door_pic')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="渠道展厅照片" prop="channel_hall_pic">
              <el-upload ref="channel_hall_pic" :file-list="channel_hall_picfileList" action="#"
                         :data="channel_hall_pic" :http-request="fileUpload" :on-preview="downloadFile"
                         :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'channel_hall_pic')}"
                         list-type="picture-card" accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,channel_hall_picfileList,'channel_hall_pic')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="渠道门店周围" prop="channel_around_pic">
              <el-upload ref="channel_around_pic" :file-list="channel_around_picfileList" action="#"
                         :data="channel_around_pic" :http-request="fileUpload" :on-preview="downloadFile"
                         :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'channel_around_pic')}"
                         list-type="picture-card" accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,channel_around_picfileList,'channel_around_pic')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="渠道负责人身份证" prop="channel_director_idcard">
              <el-upload ref="channel_director_idcard" :file-list="channel_director_idcardfileList" action="#"
                         :data="channel_director_idcard" :http-request="fileUpload" :on-preview="downloadFile"
                         :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'channel_director_idcard')}"
                         list-type="picture-card" accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,channel_director_idcardfileList,'channel_director_idcard')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="协议" prop="agreement">
              <el-upload ref="agreement" :file-list="agreementfileList" action="#" :data="agreement"
                         :http-request="fileUpload" :on-preview="downloadFile" :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'agreement')}"
                         list-type="picture-card" accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,agreementfileList,'agreement')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="其他" prop="others">
              <el-upload ref="others" :file-list="othersfileList" action="#" :data="others"
                         :http-request="fileUpload" :on-preview="downloadFile" :show-file-list="true"
                         :on-remove="(file,fileList) =>{deleteFile(file, fileList,'others')}" list-type="picture-card"
                         accept="png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf">
                <i class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                    <span class="el-upload-list__item-preview" @click="pictureCardPreview(file)">
                      <i class="el-icon-zoom-in"></i>
                    </span>
                    <span class="el-upload-list__item-delete" @click="downloadFile(file)">
                      <i class="el-icon-download"></i>
                    </span>
                    <span v-if="!false" class="el-upload-list__item-delete"
                          @click="deleteFile(file,othersfileList,'others')">
                      <i class="el-icon-delete"></i>
                    </span>
                  </span>
                  <el-dialog v-model:visible="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                  </el-dialog>
                </div>
              </el-upload>
            </el-form-item>
          </el-col>
        </el-row>
      </el-row>
      <el-row style="" class="web-box">
        <el-form-item label-width="0">
          <div style="font-size:14px;">账户信息</div>
        </el-form-item>
        <el-row style="">
          <el-col :span="8">
            <el-form-item label="收款账户性质" prop="payee_account_type">
              <el-select size="mini" v-model="docData.payee_account_type" placeholder="请选择收款账户性质" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in payee_account_typeOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="户名" prop="account_name">
              <el-input v-model="docData.account_name" size="mini" placeholder="请输入户名" :maxlength="100"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="联行号" prop="bank_number">
              <el-input v-model="docData.bank_number" size="mini" placeholder="请输入联行号" :maxlength="12"
                        clearable :style="{width: '100%'}" @change="findBank"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="开户行" prop="bank_name">
              <el-select size="mini" v-model="docData.bank_name" placeholder="请选择开户行" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in bank_nameOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="分行、支行信息" prop="bank_info">
              <el-input v-model="docData.bank_info" size="mini" placeholder="请输入分行、支行信息" :maxlength="200"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="账号" prop="account_number">
              <el-input v-model="docData.account_number" size="mini" placeholder="请输入账号" :maxlength="30"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-row>
      <el-row style="" class="web-box">
        <el-form-item label-width="0">
          <div style="font-size:14px;">经营信息</div>
        </el-form-item>
        <el-row style="">
          <el-col :span="8">
            <el-form-item label="经营年限（年）" prop="operating_year">
              <el-input v-model="docData.operating_year" size="mini" placeholder="请输入经营年限" :maxlength="3"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="月销售量（台）" prop="month_sell_amount">
              <el-input v-model="docData.month_sell_amount" size="mini" placeholder="请输入月销售量" :maxlength="10"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="月均第三方金额单量（台）" prop="month_third_amount">
              <el-input v-model="docData.month_third_amount" size="mini" placeholder="请输入月均第三方金额单量"
                        :maxlength="10" clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="主流销售车辆" prop="mainstream_sales_vehicles">
              <el-select size="mini" v-model="docData.mainstream_sales_vehicles" placeholder="请选择主流销售车辆"
                         clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in mainstream_sales_vehiclesOptions" :key="index"
                           :label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="主流车价区间" prop="mainstream_price_range">
              <el-select size="mini" v-model="docData.mainstream_price_range" placeholder="请选择主流车价区间"
                         clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in mainstream_price_rangeOptions" :key="index"
                           :label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-row>
      <el-row style="" class="web-box">
        <el-form-item label-width="0">
          <div style="font-size:14px;">特殊标签</div>
        </el-form-item>
        <el-row style="">
          <el-col :span="8">
            <el-form-item label="集团总对总店" prop="group_head_office">
              <el-select size="mini" v-model="docData.group_head_office" placeholder="请选择集团总对总店" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in group_head_officeOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="保险机构合作店" prop="insurance_agency">
              <el-select size="mini" v-model="docData.insurance_agency" placeholder="请选择保险机构合作店" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in insurance_agencyOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否产险推荐" prop="is_recommended">
              <el-select size="mini" v-model="docData.is_recommended" placeholder="请选择是否产险推荐" clearable
                         :style="{width: '100%'}">
                <el-option v-for="(item, index) in is_recommendedOptions" :key="index" :label="item.label"
                           :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-row>
      <el-row type="flex" justify="center" align="middle" style="" class="web-box">
        <el-form-item label-width="50px" label="" prop="field108">
          <el-button type="primary" icon="el-icon-folder-checked" v-if="statusid==2" size="mini"
                     @click="saveForm"> 保存 </el-button>
        </el-form-item>
        <el-form-item label-width="50px" label="" prop="field160" class="ml15">
          <el-button type="primary" icon="el-icon-arrow-left" v-if="statusid==2" size="mini" @click="close">
            返回 </el-button>
        </el-form-item>
        <el-form-item label-width="50px" label="" prop="field159" class="ml15">
          <el-button type="primary" icon="el-icon-check" v-if="statusid==2" size="mini" @click="submitForm">
            提交 </el-button>
        </el-form-item>
      </el-row>
      <el-row id="qd">
        <el-form-item label="门店纬度" prop="store_latitude">
          <el-input v-model="docData.store_latitude" size="mini" placeholder="请输入门店纬度" clearable
                    :style="{width: '100%'}"></el-input>
        </el-form-item>
        <el-form-item label="门店经度" prop="store_longitude">
          <el-input v-model="docData.store_longitude" size="mini" placeholder="请输入门店经度" clearable
                    :style="{width: '100%'}"></el-input>
        </el-form-item>
        <el-form-item label="申请日期" prop="apply_date">
          <el-date-picker size="mini" :editable="false" v-model="docData.apply_date" format="yyyy-MM-dd"
                          value-format="yyyy-MM-dd" :style="{width: '100%'}" placeholder="请选择申请日期" clearable>
          </el-date-picker>
        </el-form-item>
        <el-form-item label="按钮" prop="field132">
          <el-button type="primary" icon="el-icon-search" v-if="statusid==2" size="mini" @click="faqi"> 按钮
          </el-button>
        </el-form-item>
        <el-col :span="14">
          <el-form-item label="渠道id" prop="channelId">
            <el-input v-model="docData.channelId" size="mini" placeholder="渠道id"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
module.exports = {
  components: {},
  props: ['saveData', 'selectListRow', 'docData', 'ctx', 'tableConf', 'tableButtonList', 'statusid',
    'tableRefresh'
  ],
  data() {
    return {
      hiddenData: {
        "documentId": "633640",
        "actId": "144",
        "activityId": "144",
        "readOnly": null,
        "documentName": "channel_apply",
        "parentId": "633640",
        "cascader": [{
          "fieldName": "manage_addr",
          "treeName": "region",
          "nodeType": "node",
          "options": "manage_addrOptions"
        }],
        "fileFiledName": ["business_license", "channel_door_pic", "channel_hall_pic", "channel_around_pic",
          "channel_director_idcard", "agreement", "others"
        ],
        "tableField": [],
        "normalField": ["channel_name", "business_type", "has_license", "SUCC", "manage_addr",
          "detail_addr", "store_addr", "establishment_time", "contact_name", "contact_idcard",
          "contact_tel", "remark_info", "payee_account_type", "account_name", "bank_number", "bank_name",
          "bank_info", "account_number", "operating_year", "month_sell_amount", "month_third_amount",
          "mainstream_sales_vehicles", "mainstream_price_range", "group_head_office", "insurance_agency",
          "is_recommended", "store_latitude", "store_longitude", "apply_date", "channelId"
        ],
        "selectTreeFields": ["channel_maintainer"]
      },
      rules: {
        channel_name: [{
          required: true,
          message: '请输入渠道名称',
          trigger: 'blur'
        }],
        business_type: [{
          required: true,
          message: '请选择业务类型',
          trigger: 'change'
        }],
        has_license: [{
          required: true,
          message: '请选择是否有营业执照',
          trigger: 'change'
        }],
        SUCC: [{
          required: true,
          message: '请输入社会统一信用代码',
          trigger: 'blur'
        }],
        manage_addrOptionsValue: [{
          required: true,
          type: 'array',
          message: '请至少选择一个经营地址',
          trigger: 'change'
        }],
        detail_addr: [],
        store_addr: [{
          required: true,
          message: '点击选择门店地址',
          trigger: 'blur'
        }],
        establishment_time: [{
          required: true,
          message: '请选择成立时间',
          trigger: 'change'
        }],
        channel_maintainer: [{
          required: true,
          message: '请输入渠道维护人',
          trigger: 'blur'
        }],
        contact_name: [{
          required: true,
          message: '请输入联系人姓名',
          trigger: 'blur'
        }],
        contact_idcard: [{
          required: true,
          message: '请输入联系人身份证',
          trigger: 'blur'
        }],
        contact_tel: [{
          required: true,
          message: '请输入联系人电话',
          trigger: 'blur'
        }, {
          pattern: /^[0-9]+$/,
          message: '格式错误',
          trigger: 'blur'
        }],
        remark_info: [],
        business_license: [{
          required: true,
          message: "请上传【营业执照】!",
          trigger: "change"
        }],
        channel_door_pic: [{
          required: true,
          message: "请上传【渠道门头照片】!",
          trigger: "change"
        }],
        channel_hall_pic: [{
          required: true,
          message: "请上传【渠道展厅照片】!",
          trigger: "change"
        }],
        channel_around_pic: [{
          required: true,
          message: "请上传【渠道门店周围】!",
          trigger: "change"
        }],
        channel_director_idcard: [{
          required: true,
          message: "请上传【渠道负责人身份证】!",
          trigger: "change"
        }],
        agreement: [{
          required: true,
          message: "请上传【协议】!",
          trigger: "change"
        }],
        others: [{
          required: false,
          message: "请上传【其他】!",
          trigger: "change"
        }],
        payee_account_type: [{
          required: true,
          message: '请选择收款账户性质',
          trigger: 'change'
        }],
        account_name: [{
          required: true,
          message: '请输入户名',
          trigger: 'blur'
        }],
        bank_number: [],
        bank_name: [{
          required: true,
          message: '请选择开户行',
          trigger: 'change'
        }],
        bank_info: [{
          required: true,
          message: '请输入分行、支行信息',
          trigger: 'blur'
        }],
        account_number: [{
          required: true,
          message: '请输入账号',
          trigger: 'blur'
        }],
        operating_year: [{
          required: true,
          message: '请输入经营年限',
          trigger: 'blur'
        }, {
          pattern: /^[0-9]+$/,
          message: '格式错误',
          trigger: 'blur'
        }],
        month_sell_amount: [{
          required: true,
          message: '请输入月销售量',
          trigger: 'blur'
        }, {
          pattern: /^[0-9]+$/,
          message: '格式错误',
          trigger: 'blur'
        }],
        month_third_amount: [{
          required: true,
          message: '请输入月均第三方金额单量',
          trigger: 'blur'
        }, {
          pattern: /^[0-9]+$/,
          message: '格式错误',
          trigger: 'blur'
        }],
        mainstream_sales_vehicles: [{
          required: true,
          message: '请选择主流销售车辆',
          trigger: 'change'
        }],
        mainstream_price_range: [{
          required: true,
          message: '请选择主流车价区间',
          trigger: 'change'
        }],
        group_head_office: [{
          required: true,
          message: '请选择集团总对总店',
          trigger: 'change'
        }],
        insurance_agency: [{
          required: true,
          message: '请选择保险机构合作店',
          trigger: 'change'
        }],
        is_recommended: [{
          required: true,
          message: '请选择是否产险推荐',
          trigger: 'change'
        }],
        store_latitude: [],
        store_longitude: [],
        apply_date: [],
        channelId: [{
          pattern: /^[0-9]+$/,
          message: '格式错误',
          trigger: 'blur'
        }],
      },
      xym: true,
      manage_addrProps: {
        multiple: false,
        checkStrictly: undefined
      },
      manage_addrOptionsValue: [],
      business_license: {
        fieldName: "business_license",
        savePath: "myFile",
        fileList: "business_licensefileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      channel_door_pic: {
        fieldName: "channel_door_pic",
        savePath: "myFile",
        fileList: "channel_door_picfileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      channel_hall_pic: {
        fieldName: "channel_hall_pic",
        savePath: "myFile",
        fileList: "channel_hall_picfileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      channel_around_pic: {
        fieldName: "channel_around_pic",
        savePath: "myFile",
        fileList: "channel_around_picfileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      channel_director_idcard: {
        fieldName: "channel_director_idcard",
        savePath: "myFile",
        fileList: "channel_director_idcardfileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      agreement: {
        fieldName: "agreement",
        savePath: "myFile",
        fileList: "agreementfileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      others: {
        fieldName: "others",
        savePath: "myFile",
        fileList: "othersfileList",
        fileTypeAllow: "png,jpg,jpeg,webp,ico,bmp,gif,tif,tga,pdf,"
      },
      fileFiledName: ["business_license", "channel_door_pic", "channel_hall_pic", "channel_around_pic",
        "channel_director_idcard", "agreement", "others"
      ],
      tableField: [],
      normalField: ["channel_name", "business_type", "has_license", "SUCC", "manage_addr", "detail_addr",
        "store_addr", "establishment_time", "contact_name", "contact_idcard", "contact_tel",
        "remark_info", "payee_account_type", "account_name", "bank_number", "bank_name", "bank_info",
        "account_number", "operating_year", "month_sell_amount", "month_third_amount",
        "mainstream_sales_vehicles", "mainstream_price_range", "group_head_office", "insurance_agency",
        "is_recommended", "store_latitude", "store_longitude", "apply_date", "channelId"
      ],
      tablePage: {},
      AOPFunction: [{
        "pageLoad": "if(this.docData.has_license==0){\r\n    this.$refs.subVue.xym=false;\r\n}\r\nthis.autoSave=true;\r\nthis.saveDetails=true;\r\nlet myDate = new Date();\r\n//获取当前年\r\nlet year = myDate.getFullYear();\r\n//获取当前月\r\nlet month = myDate.getMonth() + 1;\r\n//获取当前日\r\nlet date = myDate.getDate();\r\nlet h = myDate.getHours();       //获取当前小时数(0-23)\r\nlet m = myDate.getMinutes();     //获取当前分钟数(0-59)\r\nlet s = myDate.getSeconds();\r\nlet date1 =  year + '-' + p(month) + \"-\" + p(date);\r\nthis.$set(this.docData,'apply_date',date1)\r\n//debugger;\r\nif(this.docData.ATTR_channel_maintainer==''||this.docData.ATTR_channel_maintainer==undefined){\r\n    this.$set(this.docData,'ATTR_channel_maintainer',this.user.userName)\r\n    this.$set(this.docData,'channel_maintainer',this.user.employeeId)\r\n}\r\n\r\nfunction p(s) {\r\n        return s < 10 ? '0' + s : s;\r\n}"
      }, {
        "submitSuccess": ""
      }, {
        "beforeUpload": "if(this.docNo==\"\"){\r\n    await this.saveData(this.docData,false)\r\n}\r\n"
      }, {
        "mapCallback": "self.$set(self.docData,\"store_addr\",data.address)\r\nself.$set(self.docData,\"store_longitude\",data.longitude)\r\nself.$set(self.docData,\"store_latitude\",data.latitude)\r\n "
      }],
      business_licensefileList: [],
      channel_door_picfileList: [],
      channel_hall_picfileList: [],
      channel_around_picfileList: [],
      channel_director_idcardfileList: [],
      agreementfileList: [],
      othersfileList: [],
      business_typeOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      has_licenseOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      manage_addrOptions: [],
      payee_account_typeOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      bank_nameOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      mainstream_sales_vehiclesOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      mainstream_price_rangeOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      group_head_officeOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      insurance_agencyOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      is_recommendedOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      tableConfSub: {},
      dialogImageUrl: '',
      dialogVisible: false,
      selectListRow: [],
      loading: false,
      selectFields: [{
        "metaName": "business_type",
        "metaConfig": "593465",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "has_license",
        "metaConfig": "588803",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "payee_account_type",
        "metaConfig": "593470",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "bank_name",
        "metaConfig": "593473",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "mainstream_sales_vehicles",
        "metaConfig": "593506",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "mainstream_price_range",
        "metaConfig": "593511",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "group_head_office",
        "metaConfig": "588803",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "insurance_agency",
        "metaConfig": "588803",
        "filterField": "null",
        "otherParam": "null"
      }, {
        "metaName": "is_recommended",
        "metaConfig": "588803",
        "filterField": "null",
        "otherParam": "null"
      }]
    }
  },
  computed: {},
  watch: {},
  created() {
    this.changData()
  },
  mounted() {},
  methods: {
    changData() {
      this.loading = true
      this.$emit("change-data", this.hiddenData, this.AOPFunction)
      this.loading = false
    },
    changeTableConf() {
      this.tableConfSub = this.tableConf;
    },
    resetForm() {
      this.$refs['cloudForm'].resetFields()
    },
    tableRecordAdd(tableKey, tableTemplate, defaultValue, maxSize, otherAction) { //表记录增加
      this.$emit('table-record-add', tableKey, tableTemplate, defaultValue, maxSize, otherAction)
    },
    chooseTree(treeName, multiSelect, nodeType, row) {
      this.$emit('choose-tree', "", treeName, multiSelect, nodeType, row)
    },
    selectChange(tableName, selection) {
      this.selectListRow = selection
      this.$emit('change-row-sate', tableName, selection)
    },
    selectTreeField(id, treeName, validScript, filterField, multiSelect) {
      this.$emit('select-tree-field', id, treeName, validScript, filterField, multiSelect)
    },
    delRowData(tableName) {
      this.$emit('del-row-data', tableName, this.selectListRow)
    },
    fileUpload(content) {
      // console.log('上传数据 ',content)
      // let arr = content.data.fileTypeAllow.split(',')
      // let isbuer = false
      // for(let i=0;i<arr.length;i++){
      //   if(arr[i]==content.file.name.substring(content.file.name.indexOf('.'))){
      //     isbuer = true
      //   }
      // }
      // if(isbuer){
      this.$emit('file-upload', content)
      // }else{
      //   this.$message.error('您上传的文件类型错误！')
      //   this.$emit('get-doc-data','')
      // }
    },
    downloadFile(file) {
      this.$emit('download-file', file)
    },
    deleteFile(file, fileList, fieldName) {
      let thisFiledName = []
      for (let i = 0; i < this.hiddenData.fileFiledName.length; i++) {
        if (this.hiddenData.fileFiledName[i] == fieldName) {
          thisFiledName.push(this.hiddenData.fileFiledName[i])
        }
      }
      if (thisFiledName.length > 0 && !this.$refs[fieldName].disabled) {
        this.$emit('delete-file', file, fileList, fieldName)
      }
      else {
        this.$message({
          message: '您无权限操作！',
          type: 'error'
        })
      }
    },
    pictureCardPreview(file, fileList) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    exportDetail(tableName) {
      this.$emit('export-detail', tableName)
    },
    importDetail(content, tableName) {
      this.$emit('import-detail', content)
    },
    saveDetail(tableName) {
      this.$emit('save-detail', tableName)
    },
    changePage(tableName, num) {
      this.tablePage[tableName].nowPage = this.tablePage[tableName].nowPage + num
    },
    getDetailByPage(tableName, recordNum, pageNum) {
      this.tablePage[tableName].nowPage = pageNum
      this.$emit('get-detail-by-page', tableName, recordNum, pageNum)
    },
    currentChange(tableName, recordNum, pageNum) {
      this.$emit('get-detail-by-page', tableName, recordNum, pageNum)
    },
    ownDesignFunction(tableName, functionParam) {
      this.$emit('btn-own-design-function', tableName, functionParam)
    },
    doFunction() {
      console.log("测试多参数输出", arguments)
      let trigger = arguments[0]
      let column = arguments[1]
      let row = arguments[2]
      if (column.functions != {}) {
        if (column.functions[trigger] != undefined) {
          for (let thisFunction of column.functions[trigger]) {
            let params = thisFunction.functionParam
            if (';'.indexOf(thisFunction.funcitonName) != -1) {
              let functionNameArr = thisFunction.funcitonName.split(";")
              for (let thisFunctionName of functionNameArr) {
                eval("this." + thisFunctionName + "(" + params + ")")
              }
            }
            else {
              let functionName = thisFunction.functionName
              eval("this." + functionName + "(" + params + ")")
            }
          }
        }
      }
    },
    doSummary(tableName, row, column, rowIndex, columnIndex) {
      console.log("输出变量tableName的值为：", tableName)
      console.log("输出变量row的值为：", row)
      console.log("输出变量column的值为：", column)
      console.log("输出变量rowIndex的值为：", rowIndex)
      console.log("输出变量columnIndex的值为：", columnIndex)
    },
    change(value) {
      if (value == 0) {
        this.xym = false;
      }
      else {
        this.xym = true;
      }
    },
    changFunction(fieldName) {
      let result = this.$refs[fieldName].getCheckedNodes()
      let final = []
      for (let resultElement of result) {
        final.push(resultElement.value)
      }
      let resultModel = final.join()
      this.$set(this.docData, fieldName, resultModel)
    },
    visibleChange(flag, name) {
      if (flag) {
        this.$set(this.docData, name, "")
        name = name + "Options"
        this.$set(this.docData, name, "")
      }
    },
    chooseMaps() {
      let defaultValue = {
        address: this.docData.store_addr == undefined ? "" : this.docData.store_addr,
        longitude: "",
        latitude: ""
      }
      this.$emit("choose-map", "baiduMap", "store_addr", defaultValue)
    },
    findBank(bank_code) {
      let self = this;
      let doUrl = this.ctx + '/objInfo.get?actType=runSql&sql=queryBank&bank_code=' + bank_code;
      axios.get(doUrl).then(async function(response) {
        debugger;
        if (response.data.data.length > 0) {
          self.$set(self.docData, "bank_name", response.data.data[0].bank_easy_code)
          self.$set(self.docData, "bank_info", response.data.data[0].bank_dtl_name)
        }
        else {
          alert("请输入正确联行号");
        }
      })
    },
    saveForm() {
      this.$emit('save-data', this.docData)
    },
    close() {
      parent.layer.close(parent.layer.index);
    },
    async submitForm() {
      debugger
      let keys = Object.keys(this.rules)
      for (let thisFieldName of keys) {
        let res = this.$refs.cloudForm.validate(thisFieldName)
        console.log('验证字段' + thisFieldName + '结果是：', res)
      }
      this.$refs.cloudForm.validate(valid => {
        if (!valid) return
        // TODO 提交表单 发起流程
        this.$emit('submit-form', this.docData)
      })
    },
    faqi() {
      let url = "./eqianbao.get";
      let param = {
        "type": "sign",
        "templateId": "47d85b1590ed4eaeb73ad1a22326e5f6",
        "employeeId": '655349',
        "docNo": "EMP_000000000207",
        "fileName": "入职合同.pdf",
        "tableName": "std_employee",
        "documentId": "632969",
        "taskId": "7459"
      }
      console.log("task", this.$parent.taskId);
      console.log("doc", this.$parent.docNo);
      console.log("this.$parent", this.$parent);
      console.log("param", param);
      axios.post(url, param).then(function(response) {
        debugger;
        console.log("res:", response);
        if (response.data.success) {
          let data = JSON.parse(response.data.data);
        }
        else {
          self.$alert(response.data.msg, '错误提示！')
        }
      }).catch(err => {
        console.log("系统异常：", err);
      })
    },
    //级联选择数据初始化
    getTreeNodeOptions(treeName, options, fieldName, nodeType, objectName) {
      this.$emit("init-cascader", treeName, options, fieldName, nodeType, objectName)
    },
  }
}

</script>
<style>
#qd {
  display: none;
}

</style>
