// 先取出mode环境
const minimist = require('minimist')
const argv = minimist(process.argv.slice(2),[{string: 'mode'}])
const mode = argv.mode

// 根据mode环境加载不同的env文件
const dotenv = require('dotenv');
const fs = require('fs');
const path = require('path');
const config = dotenv.parse(fs.readFileSync(path.join(__dirname, `../.${mode}.env`)));
for (const k in config ) {
  process.env[k] = config[k]
}