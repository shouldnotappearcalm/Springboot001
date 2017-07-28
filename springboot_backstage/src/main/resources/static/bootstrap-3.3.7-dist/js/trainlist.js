/**
 * Created by GZR on 2017/7/13.
 */
var args=['id','type','startStation','endStation','runTime','distance'];
function  PackageData(res) {
    var content="";

    $.each(res,function (i,o) {

        content+="<tr><td><input type='checkbox' value='1' name=''></td>";
        for(var n=0;n<args.length;n++){
            var arg=args[n];
            content+="<td>"+o[arg]+"</td>";
        }
        var myUrl="";
        //var myUrl="/admin/editStation/"+o['id'];
        //console.log(myUrl);
        content+="<td class=\"td-manage\"><a title=\"编辑\" href=\"javascript:;\" onclick=\"member_edit(\'编辑\','"+myUrl+"',\'4\',\'\',\'510\')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a><a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,"+o["id"]+")\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a></td></tr>"

    });
    return content;
}