<#macro header page_tab>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="/kaopu/?tab=good">${site.name!}</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                <div class="d-flex justify-content-start">
                    <ul class="navbar-nav">
                        <li class="nav-item <#if page_tab == "index">active</#if>">
                            <a href="/kaopu/?tab=good" class="nav-link">
                                <i class="fa fa-home"></i> ${i18n.getMessage("index")}
                            </a>
                        </li>
                        <li class="nav-item <#if page_tab == "tags">active</#if>">
                            <a href="/kaopu/tags" class="nav-link">
                                <i class="fa fa-tags"></i> ${i18n.getMessage("tag")}
                            </a>
                        </li>
                    </ul>
                    <form class="form-inline wrap" action="/kaopu/search">
                        <div class="search">
                            <input class="searchTerm" type="search" name="keyword" placeholder="回车搜索" value="${keyword!}" required aria-label="Search">
                            <button type="submit" class="searchButton">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
                <ul class="navbar-nav">
                    <#if _user??>
                        <li class="nav-item <#if page_tab == "notification">active</#if>">
                            <a href="/kaopu/notifications" class="nav-link">
                                <i class="fa fa-envelope"></i> ${i18n.getMessage("notification")}
                                <span class="badge badge-default" id="nh_count"></span>
                            </a>
                        </li>
                        <li class="nav-item <#if page_tab == "user">active</#if>">
                            <a href="/kaopu/user/${_user.username}" class="nav-link">
                                <i class="fa fa-user"></i> 我的帖子
                            </a>
                        </li>
                        <li class="nav-item <#if page_tab == "settings">active</#if>">
                            <a href="/kaopu/settings" class="nav-link">
                                <i class="fa fa-cog"></i> ${i18n.getMessage("setting")}
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:if(confirm('确定要登出吗？登出了就没办法发帖回帖了哦!'))window.location.href='/kaopu/logout'"
                               class="nav-link">
                                <i class="fa fa-sign-out"></i> ${i18n.getMessage("logout")}
                            </a>
                        </li>
                    <#else>
                        <li class="nav-item <#if page_tab == "login">active</#if>">
                            <a href="/kaopu/login" class="nav-link">
                                <i class="fa fa-sign-in"></i> ${i18n.getMessage("login")}
                            </a>
                        </li>
                        <li class="nav-item <#if page_tab == "register">active</#if>">
                            <a href="/kaopu/register" class="nav-link">
                                <i class="fa fa-sign-out"></i> ${i18n.getMessage("register")}
                            </a>
                        </li>
                        <#if !model.isEmpty(site.oauth_github_client_id!)>
                            <li class="nav-item">
                                <a href="/kaopu/oauth/github" class="nav-link">
                                    <i class="fa fa-github"></i> ${i18n.getMessage("github_login")}
                                </a>
                            </li>
                        </#if>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</#macro>
