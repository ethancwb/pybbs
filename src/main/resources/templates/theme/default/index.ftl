<#include "layout/layout.ftl"/>
<@html page_title="首页" page_tab="index">
    <#if active?? && active>
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            <strong>激活成功</strong>
        </div>
    </#if>
    <div class="row">
        <div class="col-md-9">
            <div class="card main-card yellow-border-card">
                <div class="card-header">
                    <div class="suggest_users">
                        <div class="single_logo"></div>
                        <div class="single_logo"></div>
                        <div class="single_logo"></div>
                        <div class="single_logo"></div>
                    </div>
                    <ul class="nav nav-pills">
                        <li class="nav-item"><a class="nav-link <#if tab=="good">active</#if>" href="/kaopu/?tab=good">精华</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="hot">active</#if>" href="/kaopu/?tab=hot">最热</a>
                        </li>
                            <li class="nav-item"><a class="nav-link <#if tab=="newest">active</#if>"
                                                    href="/kaopu/?tab=newest">最新</a>
                            </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="求职">active</#if>"
                                                href="/kaopu/?tab=求职">求职</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="同城">active</#if>"
                            href="/kaopu/?tab=同城">同城</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="学校">active</#if>"
                                                href="/kaopu/?tab=学校">学校</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="学术">active</#if>"
                            href="/kaopu/?tab=学术">学术</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="爱好">active</#if>"
                            href="/kaopu/?tab=爱好">爱好</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="管理">active</#if>"
                                                href="/kaopu/?tab=管理">管理</a>
                        </li>
                        <li class="nav-item"><a class="nav-link <#if tab=="其他">active</#if>"
                            href="/kaopu/?tab=其他">其他</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body">
                    <@tag_topics pageNo=pageNo!1 tab=tab!"all">
                        <#include "components/topics.ftl"/>
                        <@topics page=page/>

                        <#include "components/paginate.ftl"/>
                        <@paginate currentPage=page.current totalPage=page.pages actionUrl="/" urlParas="&tab=${tab!}"/>
                    </@tag_topics>
                </div>
            </div>
        </div>
        <div class="col-md-3 d-none d-md-block">
            <#if _user??>
                <#include "components/user_info.ftl"/>
            <#else>
                <#include "components/welcome.ftl"/>
            </#if>
            <#include "components/score.ftl"/>
            <@score limit=10/>
        </div>
    </div>
</@html>
