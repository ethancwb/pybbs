<#macro header page_tab>
  <header>
    <ul>
      <li><a href="/kaopu/" class="title">${site.name}</a></li>
      <li <#if page_tab == "good">class="active"</#if>><a href="/kaopu/?tab=good">精华</a></li>
      <li <#if page_tab == "hot">class="active"</#if>><a href="/kaopu/?tab=hot">最热</a></li>
      <li <#if page_tab == "newest">class="active"</#if>><a href="/kaopu/?tab=newest">最新</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=求职">求职</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=同城">同城</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=学校">学校</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=学术">学术</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=爱好">爱好</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=管理">管理</a></li>
      <li <#if page_tab == "noanswer">class="active"</#if>><a href="/kaopu/?tab=其他">其他</a></li>
    </ul>
    <ul>
      <#if _user??>
        <li <#if page_tab == "create">class="active"</#if>><a href="/kaopu/topic/create">创建话题</a></li>
        <li <#if page_tab == "notifications">class="active"</#if>><a href="/kaopu/notifications">通知 <span id="notReadCount">0</span></a></li>
        <li <#if page_tab == "user">class="active"</#if>><a href="/kaopu/user/${_user.username}">${_user.username}</a></li>
        <li <#if page_tab == "settings">class="active"</#if>><a href="/kaopu/settings">设置</a></li>
        <li><a href="javascript:if(confirm('确定要登出吗？'))location.href='/kaopu/logout'">登出</a></li>
      <#else>
        <li <#if page_tab == "login">class="active"</#if>><a href="/kaopu/login">登录</a></li>
        <li <#if page_tab == "register">class="active"</#if>><a href="/kaopu/register">注册</a></li>
        <li><a href="/kaopu/oauth/github">Github 登录</a></li>
      </#if>
    </ul>
  </header>
  <#if _user??>
    <script>
      $.ajax({
        url: '/api/notification/notRead',
        cache: false,
        async: false,
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        headers: {
          'token': '${_user.token}'
        },
        success: function (data) {
          if (data.code === 200) {
            if (data.detail > 0) {
              document.title = "("+data.detail+") " + document.title;
              $("#notReadCount").text(data.detail);
              $("#notReadCount").show();
            }
          }
        }
      })
    </script>
  </#if>
</#macro>
