insert into ${tableName}
<trim prefix="(" suffix=")" suffixOverrides=",">
    <#if keyProperty ??>
        ${keyColumn},
    </#if>
    <#list fieldList as field>
        <if test="${field.property} != null">
            ${field.column},
        </if>
    </#list>
</trim>
values
<trim prefix="(" suffix=")" suffixOverrides=",">
    <#if keyProperty ??>
        ${r'#{'}${keyProperty}${r'}'},
    </#if>
    <#list fieldList as field>
        <if test="${field.property} != null">
            ${r'#{'}${field.property}${r'}'},
        </if>
    </#list>
</trim>
on duplicate key update
<trim suffixOverrides=",">
    <#if keyProperty ??>
        ${keyColumn} = ${r'#{'}${keyProperty}${r'}'},
    </#if>
    <#list fieldList as field>
        <if test="${field.property} != null">
            ${field.column} = ${r'#{'}${field.property}${r'}'},
        </if>
    </#list>
</trim>