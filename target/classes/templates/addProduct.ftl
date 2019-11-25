<#include "security.ftl">

<div>
    <div> Username : ${name}</div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>


    <div>Добавить товар</div>
    <form method="post" action="addProducts">
        <input type="text" name="product_name" placeholder="Наименование товара"/>
        <input type="text" name="category" placeholder="Категория"/>
        <input type="text" name="vendor" placeholder="Производитель"/>
        <input type="text" name="description" placeholder="Описание"/>
        <input type="number" name="price" placeholder="ЦЕНА"/>
        <input type="number" name="discount" placeholder="СКИДКА"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button type="submit">Добавить</button>
    </form>

<#list pro as pr>
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
<div>
    <a href="/main">К СПИСКУ ТОВАРОВ</a>
</div>





