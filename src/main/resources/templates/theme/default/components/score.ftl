<#macro score limit top100=false>
    <div class="card">
        <div class="card-header">
            积分榜
            <#if !top100>
                <span class="pull-right"><a href="/kaopu/top100">Top100</a></span>
            </#if>
        </div>
        <table class="table">
            <#if top100>
                <tr>
                    <th>用户名</th>
                    <th>积分</th>
                </tr>
            </#if>
            <@tag_score limit=limit>
                <#list users as user>
                    <tr class="row">
                        <td class="col-sm-6" style="padding-left: 2.5rem"><a href="/kaopu/user/${user.username}">${user.username}</a></td>
                        <td class="col-sm-6 ml-auto text-right" style="padding-right: 2.5rem">${user.score}</td>
                    </tr>
                </#list>
            </@tag_score>
        </table>
    </div>
</#macro>
