<div class="card">
    <div class="card-body pb-2 mt-2">
        <div class="media">
            <a href="/user/${_user.username!}" class="mr-3">
                <img src="${_user.avatar!}" title="${_user.username!}" class="avatar"/>
            </a>
            <div class="media-body">
                <div>
                    <a href="/user/${_user.username!}">${_user.username!}</a>
                    <div style="color: #7A7A7A; font-size: 12px; margin-top:5px;">
                        <i>${(_user.bio!"这家伙很懒，什么都没有留下")?html}</i>
                    </div>
                </div>
            </div>
        </div>
        <div class="mt-4">
            <div class="row">
                <div class="col-sm-6 less-padding">
                    <a class="btn btn-primary" href="/topic/create" style="min-width: 100%" role="button">
                        <span class="fa fa-pencil"></span><i>发贴</i>
                    </a>
                </div>
                <div class="col-sm-6 less-padding">
                    <a class="btn btn-primary" href="/topic/create" style="min-width: 100%" role="button">
                        <span class="loginIcon"></span><i>签到</i>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer pt-2 pb-2" style="background-color: white; font-size: 14px;">
        <div class="row">
            <span class="col-md-6"><a href="/notifications"><span id="n_count">0</span> 条未读消息</a></span>
            <span class="col-md-6 text-right">积分：<a href="/top100">${_user.score!0}</a></span>
        </div>
    </div>
</div>
