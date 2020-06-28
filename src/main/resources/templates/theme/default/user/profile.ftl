<#include "../layout/layout.ftl"/>
<@html page_title=user.username + " 的个人主页" page_tab="user">
    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <div class="card-body">
                    <div class="media">
                        <img src="${user.avatar!}" class="mr-3 avatar avatar-lg" alt="avatar"/>
                        <div class="media-body">
                            <h3 style="margin-top: 0">${user.username!}</h3>
                            <div>积分：<a href="/kaopu/top100">${user.score}</a></div>
                            <#if user.bio??>
                                <div><i class="gray">${user.bio!}</i></div>
                            </#if>
                            <div>收藏话题: <a href="/kaopu/user/${user.username}/collects">${collectCount!0}</a></div>
                            <div>入驻时间: ${model.formatDate(user.inTime)}</div>
<#--                            <#if user.getFriends()?seq_contains("#{user.id}")>-->
                            <#if user.username??>
                                <button class="btn btn-primary add-friend" id="delete_friend" role="button">
                                    取关
                                </button>
                            <#else>
                                <button class="btn btn-primary add-friend" id="add_friend" role="button">
                                    关注
                                </button>
                            </#if>
                        </div>
                    </div>
                </div>
                <#if user.githubName?? || user.telegramName?? || user.website??>
                    <div class="card-footer" style="background-color: #fff;">
                        <#if user.website?? && user.website != "">
                            <a href="${user.website!}" class="social_label" target="_blank"><i class="fa fa-home"
                                                                                               style="color: #91c330;"></i> ${user.website!}
                            </a>
                        </#if>
                        <#if user.githubName?? && user.githubName != "">
                            <a href="https://github.com/${user.githubName!}" class="social_label" target="_blank"><i
                                        class="fa fa-github" style="color: black;"></i> ${user.githubName!}</a>
                        </#if>
                        <#if user.telegramName?? && user.telegramName != "">
                            <a href="https://telegram.me/${user.telegramName!}" class="social_label" target="_blank"><i
                                        class="fa fa-telegram" style="color: #61a7e2;"></i> ${user.telegramName!}</a>
                        </#if>
                    </div>
                </#if>
            </div>
            <#include "../components/user_topics.ftl"/>
            <@user_topics pageNo=1 pageSize=10 username=username isFooter=true/>

            <#include "../components/user_comments.ftl"/>
            <@user_comments pageNo=1 pageSize=10 username=username isFooter=true/>
        </div>
        <div class="col-md-3 hidden-xs">
            <div class="card"><p></p></div>
            <#if githubLogin??>
                <#include "../components/github_repos.ftl"/>
            </#if>
        </div>
    </div>

    <script>
        $(function () {
            $("#add_friend").click(function () {
                var username = "${user.id}";
                var data = {
                    to: username
                };
                $.post("/kaopu/api/follow/add", data, function (data) {
                    if (data.code === 200) {
                        document.getElementById('add_friend').disabled = true;
                    }
                })
            })
        })
    </script>

    <script>
        $(function () {
            $("#delete_friend").click(function () {
                var username = "${user.id}";
                var data = {
                    to: username
                };
                $.post("/kaopu/api/follow/delete", data, function (data) {
                    if (data.code === 200) {
                        document.getElementById('delete_friend').disabled = true;
                    }
                })
            })
        })
    </script>
</@html>
