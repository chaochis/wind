let startDate = new Date("2022-02-22 08:30:00")
let endDate = new Date("2022-02-23 08:50:00")
function formatDateObject(format, date) {
  let data = date || new Date();
  /*
   * eg:format="YYYY-MM-dd hh:mm:ss";
   */
  let o = {
    "M+": data.getMonth() + 1,
    "d+": data.getDate(),
    "h+": data.getHours(),
    "m+": data.getMinutes(),
    "s+": data.getSeconds(),
    "q+": Math.floor((data.getMonth() + 3) / 3),
    "S": data.getMilliseconds()
  }

  if (/(Y+)/.test(format)) {
    format = format.replace(RegExp.$1, (data.getFullYear() + "")
      .substr(4 - RegExp.$1.length));
  }

  for (let k in o) {
    if (new RegExp("(" + k + ")").test(format)) {
      format = format.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    }
  }
  return format;
}
function getWeekDay(startDate, endDate) {
  console.log(startDate)
  console.log(endDate)
  let startCalcTime = startDate.getTime();
  let endDateTime = endDate.getTime();
  let hour = 0
  while(startCalcTime < endDateTime) {
    let endCalcTime = new Date(formatDateObject('YYYY-MM-dd 00:00:00', new Date(startCalcTime + 24 * 60 * 60 * 1000))).getTime();
    if (endCalcTime > endDateTime) {
      endCalcTime = endDateTime
    }
    let interValTime = (endCalcTime - startCalcTime) / 60 / 60 / 1000 > 8.5 ? 8.5 : (endCalcTime - startCalcTime) / 60 / 60 / 1000
    hour = hour + interValTime
    startCalcTime = endCalcTime
  }
  return hour.toFixed(1)
}
console.log(getWeekDay(startDate, endDate))
