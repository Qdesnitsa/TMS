<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <meta charset="UTF-8"></meta>
        <title>Books</title>
      </head>
      <body>
        <h3>Books available</h3>
        <table border="1">
          <tr bgcolor="aqua">
            <th align="center"><strong>Title</strong></th>
            <th align="center"><strong>First published</strong></th>
            <th align="center"><strong>Genre</strong></th>
            <th align="center"><strong>Author</strong></th>
            <th align="center"><strong>Price</strong></th>
          </tr>
          <xsl:for-each select="//book">
            <xsl:sort order="ascending" select="price"/>
            <xsl:if test="price&lt;400">
              <tr bgcolor="white">
                <td><xsl:value-of select="title" /></td>
                <td><xsl:value-of select="year" /></td>
                <td><xsl:value-of select="genre" /></td>
                <td><xsl:value-of select="author" /></td>
                <td><xsl:value-of select="price" /></td>
              </tr>
            </xsl:if>
          </xsl:for-each>
          <xsl:for-each select="//book">
            <xsl:sort order="ascending" select="price"/>
              <xsl:if test="price&gt;400">
                <tr bgcolor="fuchsia">
              <td><xsl:value-of select="title" /></td>
              <td><xsl:value-of select="year" /></td>
              <td><xsl:value-of select="genre" /></td>
              <td><xsl:value-of select="author" /></td>
              <td><xsl:value-of select="price" /></td>
            </tr>
              </xsl:if>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>