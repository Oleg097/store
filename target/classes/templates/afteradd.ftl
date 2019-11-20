<#include "security.ftl">

<div>
    <div> Username : ${name}</div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<div>
<#if myinfo??>
    <b> имя : ${myinfo.getUsername()}</b>
    <b> баланс : ${myinfo.getMoney()}</b>
    <b> ваш id: ${myinfo.getId()}</b>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<#else >
    no
</#if>
</div>

<a href="/main"> К списку товаров</a>


