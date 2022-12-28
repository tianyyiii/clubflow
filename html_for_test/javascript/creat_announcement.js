function submit()
{

}

function cancel()
{
    res=confirm("取消后所有内容不会保存，即便如此也要取消么?");
    if(res)
    {
        location.reload();
    }
}