<#include "security.ftl">

<html lang="en">
    <div>
        <div> Username : ${name}</div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Sign Out"/>
        </form>

    </div>

<div>
    <a href="/myAccount/${name}">user</a>
</div>

<div>
    <#list products as pr>
        <div>
            <b>наименование : ${pr.product_name}</b>

            <b>наименование : ${pr.vendor}</b>

            <b>наименование : ${pr.description}</b>
        </div>

    <#else >
        no
    </#list>
</div>
</html>









