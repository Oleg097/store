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
        <input type="number" name="qty" placeholder="Количество"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button type="submit">Добавить</button>
    </form>
<div>

    <#list pro as prod>
        <div>
            <b>наименование : ${prod.product_name}</b>
            <b>наименование : ${prod.vendor}</b>
            <b>наименование : ${prod.description}</b>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </div>
        <#else >
        no
    </#list>

</div>




