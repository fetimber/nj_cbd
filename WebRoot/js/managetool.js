//设置jquery.datepicker的中文显示
$.datepicker.setDefaults($.datepicker.regional['zh-CN'] = {
         closeText: '关闭',
         prevText: '上月',
         nextText: '下月',
         currentText: '今天',
         monthNames: ['一月','二月','三月','四月','五月','六月',
         '七月','八月','九月','十月','十一月','十二月'],
         monthNamesShort: ['一','二','三','四','五','六',
         '七','八','九','十','十一','十二'],
         dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
         dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
         dayNamesMin: ['日','一','二','三','四','五','六'],
         weekHeader: '周',
         dateFormat: 'yy-mm-dd',
         firstDay: 1,
         isRTL: false,
         showMonthAfterYear: true,
         yearSuffix: '年'}
);

//设置jquery.timepicker的中文显示
$.timepicker.setDefaults($.timepicker.regional['zh-CN'] = {
		timeOnlyTitle: '时间',
		timeText: '时间',
		hourText: '时',
		minuteText: '分',
		secondText: '秒',
		millisecText: '分秒',
		timezoneText: '简体中文',
		currentText: '当前时间',
		closeText: '关闭',
		timeFormat: 'hh:mm tt',
		amNames: ['AM', 'A'],
		pmNames: ['PM', 'P'],
		ampm: false,
		isRTL: false
});

//设置datetime picker的时间格式并且同时绑定“起始日期”和”截至日期“输入框显示
//datetime picker控件
$(function() {
    $("#prevDate, #endDate").datetimepicker({
    	 showSecond: true,
	 	 timeFormat: 'hh:mm:ss',
		 separator: 'T'
	});
    $("#prefDate").datetimepicker('setDate', (new Date()) );
});


$(document).ready(function() {
	
	
});