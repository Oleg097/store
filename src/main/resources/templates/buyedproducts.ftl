<div>КУПЛЕНО</div>
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
    </div>
<#else >
    no
</#list>
</div>