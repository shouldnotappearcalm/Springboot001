/**
 * Created by GZR on 2017/7/6.
 */
$(document).ready(function () {
   $('#loginAction').bootstrapValidator({
       message:"非法值！",
       feedbackIcons:{
           valid:"glyphicon glyphicon-ok",
           invalid:"glyphicon glyphicon-remove",
           validating:"glyphicon glyphicon-refresh"
       },
       fields:{
           "username":{
               message:"用户名不合法",
               validators:{
                   notEmpty:{
                       message:"用户名不能为空！"
                   },
                   stringLength:{
                       min:5,
                       max:30,
                       message:"用户名只能由5-30个字符组成！"
                   },
                   regexp:{
                       regexp:/^[a-zA-Z0-9_]+$/,
                       message:"用户名只能由字母、数字或下划线组成！"
                   }
               }
           },
           "password":{
               message:"密码不合法",
               validators:{
                   notEmpty:{
                       message:"密码不能为空！"
                   },
                   stringLength:{
                       min:6,
                       max:30,
                       message:"用户名只能由6-30个字符组成！"
                   }
               }
           }
       }
   });

});