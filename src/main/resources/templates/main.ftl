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
    <a href="/myAccount/${name}">МОИ ДАННЫЕ</a>
</div>

<div>
    <#list products as pr>
        <div>
            <b>наименование : ${pr.product_name}</b>
            <b>категория : ${pr.category}</b>
            <b>производитель : ${pr.vendor}</b>
            <b>цена : ${pr.price}</b>
            <#if pr.discount??>
                <b>скидка : ${pr.discount}</b>
            <#else >
                скидки нет(((
            </#if>
            <a href="addToBasket/${pr.getProduct_id()}/${name}">ДОБАВИТЬ В КОРЗИНУ</a>
        </div>
    <#else >
        НЕТ ТОВАРОВ В КАТАЛОГЕ
    </#list>
</div>
</html>









