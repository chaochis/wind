var express = require('express');
const connection = require("../config/database");
const {commonQuery} = require("../config/database");
const e = require("express");
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  commonQuery('select * from wind_user', []).then(res => {
    console.log(res)
    res.json({name: 1})
  }).catch(err => {
    res.json(err);
  })
});



module.exports = router;
