function follow()
{
  alert("follow")
}

function chat()
{
  alert("chat")
}

function go_to_Url(url)
{
  window.location.href=url;
}

function get_element(id) {   //封装一个函数，根据 id 来找元素的函数；
  return document.getElementById(id);
}

function create(tagName) { //封装一个根据标签名来创建新元素的函数；
  return document.createElement(tagName);
}

function F(userid,clubid)
	{
		var j_data=new Array();
		var j_label=new Array();
		var res=new Array();
		$.ajaxSetup({async:false});
				$.getJSON('http://localhost:8080/club/view',{"UserId":userid,"ClubId":clubid},function(result)
				{
					$.each(result, function(i, field)
					{
						var I=i;
						var F=field;
						j_label.push(I);
						j_data.push(F);
					});
					return j_data.length;
				});
				res.push(j_label);
				res.push(j_data);
				return res;
	};
  
	function G(userid,clubid)
	{
		var j_data=new Array();
		var j_label=new Array();
		var res=new Array();
		$.ajaxSetup({async:false});
		$.getJSON("http://localhost:8080/post/view_by_club",{"UserId":userid,"ClubId":clubid},function(result)
				{
					$.each(result, function(i, field)
					{
						var I=i;
						alert(I);
						var F=field;
						alert(F);
						j_label.push(I);
						j_data.push(F);
					});
					return j_data.length;
				});
				res.push(j_label);
				res.push(j_data);
				return res;		
	};


function Show_Announcements()
{
  var rValue=4;

  var oTable = create('table');  //使能看到添加的表格的元素，专门添加的 border 的值；
  oTable.border = 1;
  for (var i = 0; i < rValue; i++) {  //此时循环的目的：迎合你输入的行数;
    var oTr = create('tr');
    //for (var j = 0; j < cValue; j++) { //此时循环的目的：迎合输入的列数，使得表格达到你想要的情况；
      var oTd = create('td');  
      oTd.innerHTML = "aaa";                 //将 'aaa' 的值添加到每一个单元格中；
      //oTd.style.backgroundColor = getColor();//将每一个单元格中的背景色设置成随机的；
      oTr.appendChild(oTd);     //每次的 oTd 都作为 oTr 的一个子元素来添加进去；
    //}

    
    oTable.appendChild(oTr); //在 oTable(表格) 中添加 oTr(行标记)；
  }
  get_element('box').appendChild(oTable);//将 oTable 放在 id 为 box 的 div 中；
  }


/*function Show_Announcements()
{
  var rValue=4;

  var oTable = create('table');  //使能看到添加的表格的元素，专门添加的 border 的值；
  oTable.border = 1;
  for (var i = 0; i < rValue; i++) {  //此时循环的目的：迎合你输入的行数;
    var oTr = create('tr');
    //for (var j = 0; j < cValue; j++) { //此时循环的目的：迎合输入的列数，使得表格达到你想要的情况；
      var oTd = create('td');  
      oTd.innerHTML = "aaa";                 //将 'aaa' 的值添加到每一个单元格中；
      //oTd.style.backgroundColor = getColor();//将每一个单元格中的背景色设置成随机的；
      oTr.appendChild(oTd);     //每次的 oTd 都作为 oTr 的一个子元素来添加进去；
    //}

    
    oTable.appendChild(oTr); //在 oTable(表格) 中添加 oTr(行标记)；
  }
  get_element('box').appendChild(oTable);//将 oTable 放在 id 为 box 的 div 中；
  }
  */



  //任意获取 '#******' 所表示的所有的颜色值 (即：通过拼接起来的 6 个数字所表示的颜色值)；
  

  