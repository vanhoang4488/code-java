<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output omit-xml-declaration="yes" indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="apply">
        <xsl:if test="not(position()=1)">,</xsl:if>
        <xsl:apply-templates select="*[1]"/>
    </xsl:template>

    <xsl:template match="eq|plus|power|times">
        <xsl:if test="not(position()=1)">,</xsl:if>
        <xsl:value-of select="concat(name(), '(')"/>
        <xsl:apply-templates select="following-sibling::*"/>
        <xsl:text>)</xsl:text>
    </xsl:template>

    <xsl:template match="cn|ci">
        <xsl:if test="not(position()=1)">,</xsl:if>
        <xsl:value-of select="."/>
    </xsl:template>
</xsl:stylesheet>