function F(url,userid,clubid)
	{
		var j_data=new Array();
		var j_label=new Array();
		var res=new Array();
		$.ajaxSetup({async:false});
				$.getJSON(url,{"UserId":userid,"ClubId":clubid},function(result)
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

function get_list_element(list,label)
{
    for(var i=0;i<list[0].length;i++)
    {
        if(list[0][i]==label)
        {
            return list[1][i];
        }
    }
}

function show(list)
{
    var length=list[0].length;
    var div=document.getElementById("list_of_follow");
    for(var i=0;i<length;i++)
    {
        var new_div=document.createElement("div");
        var new_div1=document.createElement("div");
        var new_div2=document.createElement("div");
        var new_pic=document.createElement("img");
        new_pic.src=get_list_element(list,"profile");
        var new_name=get_list_element(list,"name");
        var new_inform=get_list_element(list,"inform");
        var new_category=get_list_element(list,"category");
        new_div1.style="float:left width:30%";
        new_div1.append(new_pic);
        new_div1.append(new_name);
        new_div1.append(new_inform);
        new_div1.append(new_category);
        new_div.append(new_div1);
        
    }
}