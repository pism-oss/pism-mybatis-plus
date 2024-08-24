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
<trim prefix="values (" suffix=")" suffixOverrides=",">
    <#if keyProperty ??>
        ${r'#{'}${keyProperty}${r'}'},
    </#if>
    <#list fieldList as field>
        <if test="${field.property} != null">
            ${r'#{'}${field.property}${r'}'},
        </if>
    </#list>
</trim>