"use strict";(self["webpackChunkclubflow"]=self["webpackChunkclubflow"]||[]).push([[177,680],{9680:function(e,s,t){t.r(s),t.d(s,{default:function(){return h}});var i=t(3396),a=t(7139),o=t(4870),l=t(7178),n=t(2655),r=t(2748),c={__name:"UpImage",props:{product_id:Number},emits:["upUrl"],setup(e,{emit:s}){const t=(0,o.qj)([]),c=(0,i.FN)()?.appContext.config.globalProperties.$Baseurl+"comment/image",d=(0,o.qj)({showBtnDealImg:!0,noneBtnImg:!1}),h=(0,o.iH)(0),p=e=>{console.log("上传前端校验",e);const s=e.size/1024/1024<2;e.type;if(!s)return l.z8.success({message:"上传图片不能超过2MB哦!"}),!1},u=(e,t)=>{console.log("handleSuccessres",e),console.log("handleSuccessfile",t),e?(l.z8.success({message:"上传成功!"}),s("upUrl",t.response.imgURL)):l.z8.error({message:"上传失败，请重新上传"})},m=(e,s)=>{console.log("file---",e),console.log("fileList---",s),d.noneBtnImg=s.length>=1},f=(e,s,t)=>{h.value=Math.floor(e.percent)},g=(e,s)=>{const t=new Promise(((t,i)=>{n.T.confirm("此操作将删除该图片, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{let t=s.indexOf(e);s.splice(t,1),d.noneBtnImg=!1})).catch((()=>{i(!1)}))}));return t};return(e,s)=>{const l=(0,i.up)("el-icon"),n=(0,i.up)("el-upload");return(0,i.wg)(),(0,i.j4)(n,{"list-type":"picture-card",action:c,class:(0,a.C_)({uoloadBtn:d.showBtnDealImg,disUoloadBtn:d.noneBtnImg}),"on-change":m,"on-success":u,"before-upload":p,"on-progress":f,"before-remove":g,"file-list":t,multiple:!0,limit:1},{default:(0,i.w5)((()=>[(0,i.Wm)(l,{class:"avatar-uploader-icon"},{default:(0,i.w5)((()=>[(0,i.Wm)((0,o.SU)(r.v37))])),_:1})])),_:1},8,["class","file-list"])}}};const d=c;var h=d},6177:function(e,s,t){t.r(s),t.d(s,{default:function(){return Ce}});var i=t(3396),a=t(7139);const o=e=>((0,i.dD)("data-v-6b2a7713"),e=e(),(0,i.Cn)(),e),l={class:"mt-3 d-flex px-3 py-3 mx-4 align-items-center justify-content-between",style:{"border-bottom":"rgb(233, 233, 233) 1px solid"}},n={class:"mx-5 d-inline-flex align-items-center"},r={id:"userimg",class:"me-4 d-flex position-relative"},c=["src"],d={class:""},h={class:"mb-0",style:{"font-size":"18px"}},p={style:{"font-family":"'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif","font-weight":"700",color:"#666666"}},u=o((()=>(0,i._)("p",{class:"mb-0",style:{"font-size":"14px"}},[(0,i._)("span",{style:{"font-family":"'微软雅黑', sans-serif","font-weight":"400",color:"#999999"}},"副标题")],-1))),m={class:"mt-5 px-5 mx-4"},f=o((()=>(0,i._)("div",{class:""},[(0,i._)("span",{class:"ms-2 me-2",style:{"font-family":"'FontAwesome', sans-serif","font-size":"22px"}},""),(0,i._)("span",{style:{"font-family":"'Microsoft JhengHei UI', sans-serif","font-size":"16px",color:"#B82D29"}},"关注列表（包括社团社区和爱好社区）"),(0,i._)("div",{class:"mt-1",style:{"background-color":"rgb(228, 228, 228)",height:"8px"}})],-1))),g={class:"my-3 px-1 py-1"},b=["onClick"],y={class:"me-5 col-2"},x=["src"],w={class:"mt-3 mb-0",style:{"font-size":"14px"}},_={class:"mb-1",style:{color:"#999999","font-size":"12px"}},v=o((()=>(0,i._)("p",{style:{color:"#999999","font-size":"12px"}},[(0,i._)("span",null,"分类："),(0,i._)("span",{style:{color:"#0079FE"}},"文化艺术类")],-1))),I={class:"",style:{}},U={class:"",style:{"text-align":"start","line-height":"18px"}},C=o((()=>(0,i._)("span",{style:{"font-family":"'Arial Normal', 'Arial', sans-serif","font-size":"15px"}},"协会简介：",-1))),z={style:{"font-family":"'华文宋体', sans-serif","font-size":"14px"}},k=["onClick"],B={class:"me-5 col-2"},H=["src"],j={class:"mt-3 mb-0",style:{"font-size":"14px"}},D={class:"mb-1",style:{color:"#999999","font-size":"12px"}},T=o((()=>(0,i._)("p",{style:{color:"#999999","font-size":"12px"}},[(0,i._)("span",null,"分类："),(0,i._)("span",{style:{color:"#0079FE"}},"爱好社区")],-1))),R={class:"",style:{}},N={class:"",style:{"text-align":"start","line-height":"18px"}},A=o((()=>(0,i._)("span",{style:{"font-family":"'Arial Normal', 'Arial', sans-serif","font-size":"15px"}},"协会简介：",-1))),E={style:{"font-family":"'华文宋体', sans-serif","font-size":"14px"}},S={class:"mt-5 px-5 mx-4"};function F(e,s,t,o,$,F){const L=(0,i.up)("UserBanner"),q=(0,i.up)("UpImage"),W=(0,i.up)("UserCreated");return(0,i.wg)(),(0,i.iD)(i.HY,null,[(0,i.Wm)(L),(0,i._)("div",l,[(0,i._)("div",n,[(0,i._)("div",r,[(0,i._)("img",{class:"rounded-circle",src:$.UserInfo.image,alt:"用户头像",style:{width:"79px",height:"79px"}},null,8,c),(0,i.Wm)(q,{onUpUrl:F.getImgURL,class:"position-absolute"},null,8,["onUpUrl"])]),(0,i._)("div",d,[(0,i._)("p",h,[(0,i._)("span",p,(0,a.zw)($.UserInfo.name),1)]),u])])]),(0,i._)("div",m,[f,(0,i._)("div",g,[((0,i.wg)(!0),(0,i.iD)(i.HY,null,(0,i.Ko)($.showlist,(e=>((0,i.wg)(),(0,i.iD)("button",{onClick:s=>F.jumpToClubShow(e.clubId),class:"py-3 px-3 w-100 d-flex",style:{"border-bottom":"1px rgba(242, 242, 242, 1) solid"}},[(0,i._)("div",y,[(0,i._)("img",{class:"rounded-circle",src:e.image,style:{height:"38px",width:"38px"}},null,8,x),(0,i._)("p",w,(0,a.zw)(e.clubName),1),(0,i._)("p",_,(0,a.zw)(e.clubInfo),1),v]),(0,i._)("div",I,[(0,i._)("div",U,[C,(0,i._)("span",z,(0,a.zw)(e.announcement),1)])])],8,b)))),256)),((0,i.wg)(!0),(0,i.iD)(i.HY,null,(0,i.Ko)($.showhabbitlist,(e=>((0,i.wg)(),(0,i.iD)("button",{onClick:s=>F.jumpToHabbitShow(e.habbitId),class:"py-3 px-3 w-100 d-flex",style:{"border-bottom":"1px rgba(242, 242, 242, 1) solid"}},[(0,i._)("div",B,[(0,i._)("img",{class:"rounded-circle",src:e.image,style:{height:"38px",width:"38px"}},null,8,H),(0,i._)("p",j,(0,a.zw)(e.habbitName),1),(0,i._)("p",D,(0,a.zw)(e.habbitInfo),1),T]),(0,i._)("div",R,[(0,i._)("div",N,[A,(0,i._)("span",E,(0,a.zw)(e.announcement),1)])])],8,k)))),256))])]),(0,i._)("div",S,[(0,i.Wm)(W)])],64)}t(7658);const L={class:"container-fluid position-relative",style:{"background-color":"rgba(102, 102, 102, 1)",height:"300px"}},q=(0,i.uE)('<button id="upcover" class="upimg" data-v-28859eb0><p class="mb-1" style="font-size:28px;" data-v-28859eb0><span style="font-family:&#39;FontAwesome Regular&#39;, &#39;FontAwesome&#39;, sans-serif;font-weight:400;" data-v-28859eb0></span></p><p class="mb-0" style="font-size:14px;" data-v-28859eb0><span style="font-family:&#39;微软雅黑&#39;, sans-serif;font-weight:400;" data-v-28859eb0>上传封面</span></p></button>',1),W=[q];function M(e,s,t,a,o,l){return(0,i.wg)(),(0,i.iD)("div",L,W)}var Y={name:"UserBanner",components:{},data(){return{UserId:0}},created(){this.UserId=this.$store.state.UserId}},J=t(89);const K=(0,J.Z)(Y,[["render",M],["__scopeId","data-v-28859eb0"]]);var Z=K,O=t(9680),P=t(1004);const V={key:0},G=(0,i._)("div",{class:""},[(0,i._)("span",{class:"ms-2 me-2",style:{"font-family":"'FontAwesome', sans-serif","font-size":"22px"}},""),(0,i._)("span",{style:{"font-family":"'Microsoft JhengHei UI', sans-serif","font-size":"16px",color:"#B82D29"}},"我创建的社团社区"),(0,i._)("div",{class:"mt-1",style:{"background-color":"rgb(228, 228, 228)",height:"8px"}})],-1),Q={class:"my-3 mx-5 px-4 px-1 py-1 d-flex justify-content-center"},X={class:"card rounded-circle position-relative",style:{overflow:"hidden",width:"150px",height:"150px"}},ee=(0,i._)("div",{class:"cover position-absolute",style:{"z-index":"1",width:"100%",height:"100%","background-color":"#B82D29",opacity:"50%",display:"none"}},null,-1),se=(0,i._)("div",{class:"arrow",style:{"z-index":"3",position:"absolute","text-align":"center",width:"100%",top:"55px",display:"none"}},[(0,i._)("img",{style:{width:"36px",height:"36px"},src:P})],-1),te=["src"],ie={class:"mt-2 mb-0",style:{"font-size":"16px","font-family":"'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif","font-weight":"700"}},ae=(0,i._)("div",{class:"rounded-circle d-flex align-items-center justify-content-center",style:{overflow:"hidden",width:"150px",height:"150px","background-color":"#e4e4e4"}},[(0,i._)("i",{class:"fa fa-plus","aria-hidden":"true",style:{color:"white","font-size":"68px"}})],-1),oe=(0,i._)("p",{class:"mt-2 mb-0",style:{"font-size":"16px","font-family":"'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif","font-weight":"700"}},"新建社团",-1),le={key:1},ne={class:""},re=(0,i._)("span",{class:"ms-2 me-2",style:{"font-family":"'FontAwesome', sans-serif","font-size":"22px"}},"",-1),ce=(0,i._)("span",{style:{"font-family":"'Microsoft JhengHei UI', sans-serif","font-size":"16px",color:"#B82D29"}},"我创建的爱好社区",-1),de=(0,i._)("i",{class:"fa fa-plus-circle ms-3","aria-hidden":"true",style:{color:"#999999"}}," 新建我的社区",-1),he=(0,i._)("div",{class:"mt-1",style:{"background-color":"rgb(228, 228, 228)",height:"8px"}},null,-1),pe={class:"my-3 mx-5 px-4 px-1 py-1"},ue=["onClick"],me={class:"card rounded-circle position-relative",style:{overflow:"hidden",width:"150px",height:"150px"}},fe=(0,i._)("div",{class:"cover position-absolute",style:{"z-index":"1",width:"100%",height:"100%","background-color":"#B82D29",opacity:"50%",display:"none"}},null,-1),ge=(0,i._)("div",{class:"arrow",style:{"z-index":"3",position:"absolute","text-align":"center",width:"100%",top:"55px",display:"none"}},[(0,i._)("img",{style:{width:"36px",height:"36px"},src:P})],-1),be=["src"],ye={class:"mt-2 mb-0",style:{"font-size":"16px","font-family":"'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif","font-weight":"700"}};function xe(e,s,t,o,l,n){const r=(0,i.up)("router-link");return l.IsClubUser?((0,i.wg)(),(0,i.iD)("div",V,[G,(0,i._)("div",Q,[l.CreatedClub?((0,i.wg)(),(0,i.iD)("button",{key:0,onClick:s[0]||(s[0]=(...e)=>n.jumpToClubEdit&&n.jumpToClubEdit(...e)),class:"text-center"},[(0,i._)("div",X,[ee,se,(0,i._)("img",{src:l.ClubImage,class:"card-img",style:{width:"100%",height:"100%","object-fit":"cover","object-position":"center"}},null,8,te)]),(0,i._)("p",ie,(0,a.zw)(l.ClubName),1)])):((0,i.wg)(),(0,i.j4)(r,{key:1,to:"/createclub",class:"text-center"},{default:(0,i.w5)((()=>[ae,oe])),_:1}))])])):((0,i.wg)(),(0,i.iD)("div",le,[(0,i._)("div",ne,[re,ce,(0,i.Wm)(r,{to:"/createhabbit"},{default:(0,i.w5)((()=>[de])),_:1}),he]),(0,i._)("div",pe,[((0,i.wg)(!0),(0,i.iD)(i.HY,null,(0,i.Ko)(l.createdHabbitsList,(e=>((0,i.wg)(),(0,i.iD)("button",{onClick:s=>n.jumpToHabbitShow(e.habbitId),class:"mx-5 px-3 my-3 text-center"},[(0,i._)("div",me,[fe,ge,(0,i._)("img",{src:e.image,class:"card-img",style:{width:"100%",height:"100%","object-fit":"cover","object-position":"center"}},null,8,be)]),(0,i._)("p",ye,(0,a.zw)(e.habbitName),1)],8,ue)))),256))])]))}var we={name:"UserCreated",data(){return{Role:3,UserId:0,IsClubUser:!1,CreatedClub:!1,ClubName:"",ClubId:0,ClubImage:t(2207),createdHabbits:null,createdHabbitsList:[]}},methods:{checkImgUrl(e){var s=/^http/g,t=s.test(e);return t},jumpToClubEdit(){this.$router.push({path:"/clubeditpage",query:{ClubId:this.ClubId}})},jumpToHabbitShow(e){this.$router.push({path:"/habbit",query:{HabbitId:e}})}},created(){this.UserId=this.$store.state.UserId,this.Role=this.$store.state.Role,this.IsClubUser=2==this.Role},mounted(){if(this.IsClubUser)this.$axios.get("club/get_created_club",{params:{UserId:this.UserId}}).then((e=>{var s=e.data;1==s.state&&(this.CreatedClub=!0,this.ClubName=s.clubName,this.checkImgUrl(s.image)&&(this.ClubImage=s.image),this.ClubId=s.ClubId)})).catch((e=>{console.log(e)}));else{let e=this;this.$axios.get("habbit/get_created_habbit",{params:{UserId:this.UserId}}).then((s=>{this.createdHabbits=s.data;for(let e in this.createdHabbits)this.createdHabbitsList.push(this.createdHabbits[e]);this.createdHabbitsList.forEach((function(s){void 0!=s["image"]&&""!=s["image"]&&e.checkImgUrl(s["image"])||(s["image"]=t(2207))}))})).catch((e=>{console.log(e)}))}setTimeout((function(){$(".card-img").mouseenter((function(){var e=$(this).siblings(".cover");e.slideDown("slow");var s=$(this).siblings(".arrow");s.delay("fast").fadeIn()})),$(".card").mouseleave((function(){var e=$(this).children(".arrow");e.fadeOut("fast");var s=$(this).children(".cover");s.delay("fast").slideUp()}))}),100)}};const _e=(0,J.Z)(we,[["render",xe]]);var ve=_e,Ie={name:"UserHome",components:{UserBanner:Z,UpImage:O["default"],UserCreated:ve},data(){return{UserId:0,UserInfo:{image:t(100),name:"用户名称",password:""},clubs:null,habbits:null,showlist:[],showhabbitlist:[]}},methods:{checkImgUrl(e){var s=/^http/g,t=s.test(e);return t},jumpToClubShow(e){this.$router.push({path:"/clubhome",query:{ClubId:e}})},jumpToHabbitShow(e){this.$router.push({path:"/habbit",query:{HabbitId:e}})},getImgURL(e){console.log("image:",e),this.UserInfo.image=e;var s={name:this.UserInfo.name,password:this.UserInfo.password,profile:this.UserInfo.image};this.$axios.post("user/modify/"+this.UserId,s).then((e=>{var s=e.data;1==s.state&&alert("头像上传成功！")})).catch((e=>{console.log(e)}))}},created(){this.UserId=this.$store.state.UserId},mounted(){this.$axios.get("user/view",{params:{UserIdtoView:this.UserId,UserId:this.UserId}}).then((e=>{var s=e.data;1==s.state&&(this.checkImgUrl(s.image)&&(this.UserInfo.image=s.image),this.UserInfo.name=s.name,this.UserInfo.password=s.passwd)})).catch((e=>{console.log(e)}));let e=this;this.$axios.get("club/view_by_account",{params:{UserId:this.UserId}}).then((s=>{this.clubs=s.data;for(let e in this.clubs)this.showlist.push(this.clubs[e]);this.showlist.forEach((function(s){void 0!=s["image"]&&""!=s["image"]&&e.checkImgUrl(s["image"])||(s["image"]=t(7566))}))})).catch((e=>{console.log(e)})),this.$axios.get("habbit/view_by_account",{params:{UserId:this.UserId}}).then((s=>{console.log(s),this.habbits=s.data;for(let e in this.habbits)this.showhabbitlist.push(this.habbits[e]);this.showhabbitlist.forEach((function(s){void 0!=s["image"]&&""!=s["image"]&&e.checkImgUrl(s["image"])||(s["image"]=t(7566))}))})).catch((e=>{console.log(e)}))}};const Ue=(0,J.Z)(Ie,[["render",F],["__scopeId","data-v-6b2a7713"]]);var Ce=Ue},1004:function(e,s,t){e.exports=t.p+"img/u40.990d7905.svg"},100:function(e,s,t){e.exports=t.p+"img/default-user-round-dark.17041ec4.png"},7566:function(e,s,t){e.exports=t.p+"img/default-user-round.c9195e07.png"},2207:function(e,s,t){e.exports=t.p+"img/default_img.ea648e07.png"}}]);
//# sourceMappingURL=177.cecab642.js.map