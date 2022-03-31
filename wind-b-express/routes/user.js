var express = require('express');
const connection = require("../config/mysql");
const {commonQuery} = require("../config/mysql");
const e = require("express");
var router = express.Router();

router.get('/getList', function(req, res, next) {
  commonQuery('select * from wind_user', []).then(results => {
    res.json(results)
  }).catch(err => {
    res.json(err);
  })
});



module.exports = router;
