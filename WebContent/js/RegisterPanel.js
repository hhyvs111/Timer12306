function validateForm(f){
			var flag=checkname(f['username'])
			&&checkname1(f['name'])
			&&checkpd(f['password'])
			&&checkrepd(f['ppass'],f['password'])
			&&validateEmail(f['email'])
			&&validateidCard(f['idCard'])
			&&checkDate(f['Date'])
			&&checkpN(f['phoneNumber']);
			return flag;
		}
			//用户名的控制函数
			function checkname(obj) {
				var div = document.getElementById('div1');
				div.innerHTML = "";
				if (obj.value.length==0) {
					div.innerHTML = '姓名不能为空！';
					return false;
				}
				if (obj.value.length < 4 || obj.value.length > 16) {
					div.innerHTML = '长度4-16个字符！';
					return false;
				}
				return true;
			}
			
			//真实姓名的控制函数
			function checkname1(obj){
			var div = document.getElementById('div1_1');
				div.innerHTML = "";
				if (obj.value.length==0) {
					div.innerHTML = '必须填入真实姓名！';
					return false;
				}
				if (obj.value.length < 2 || obj.value.length > 10) {
					div.innerHTML = '请填写真确的姓名';
					return false;
				}
				return true;
			}
	
			//密码的控制函数
			function checkpd(obj){
			var div=document.getElementById('div2');
			div.innerHTML="";
			if (obj.value.length==0) {
					div.innerHTML = '请输入密码！';
					return false;
				}
			if(obj.value.length < 4 || obj.value.length > 16){
			 div.innerHTML='密码安全性不高！';
			 return true;
			}
			return true;	
			}
			
			//重复密码的控制函数
	function checkrepd(obj,old){//给表单命名，使用document.forms['f1']['passpword'])表示获得名叫放的表单中的名家password的对象
	 var div=document.getElementById('div3');
	 div.innerHTML="";	
	 if(obj.value!=old.value){
	 div.innerHTML='两次输入密码不同';	 
	 return false;
	 }
	 return true;
	}
	
	//邮件格式控制
	function validateEmail(obj){
	var div = document.getElementById('div4');
		div.innerHTML = "";
		var reg= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (obj.value.length==0) {
			div.innerHTML = '请填写邮箱！';
			return false;
		}else if(!reg.test(obj.value)){
		div.innerHTML='请填写正确的邮件地址';
		return false;
		}
	}
	//验证身份证号码是否正确
	function validateidCard(obj){
			var div=document.getElementById('div5');
			div.innerHTML="";
			if (obj.value.length==0) {
					div.innerHTML = '请输入证件号码！';
					return false;
				}
			if(obj.value.length < 18 ){
			 div.innerHTML='证件号码输入错误！';
			 return false;
			}
			return true;	
		}
	
	function checkDate(obj){ 
		var div = document.getElementById('div8');
		div.innerHTML = "";
		var reg=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/; 
		if (obj.value.length==0) {
			div.innerHTML = '请填写生日！';
			return false;
		}else if(!(obj.value).match(reg)){
		div.innerHTML='请按格式填写生日';
		return false;
		}
} 
	function checkpN(obj){
			var div=document.getElementById('div7');
			div.innerHTML="";
			if (obj.value.length==0) {
					div.innerHTML = '请输入手机号！';
					return false;
				}
			if (obj.value.length !=11 ) {
					div.innerHTML = '长度11个字符！';
					return false;
				}
			return true;	
			}