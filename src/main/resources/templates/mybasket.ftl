<#include "security.ftl">

<div>
    <#list mybasket as pr>
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
        </div>

    <#else >
        в корзине нет товаров
    </#list>
</div>
<div>
    <div>
        <a href="/buyproducts/${name}"> КУПИТЬ ТОВАРЫ </a>
    </div>
    <div>
        <a href="/main">К СПИСКУ ТОВАРОВ</a>
    </div>
</div>