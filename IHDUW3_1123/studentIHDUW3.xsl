<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Tanuló</h2>
				<table border="2">
					<tr bgcolor="green">
						<th>id</th>
						<th>Keresztnev</th>
						<th>Vezeteknev</th>
						<th>Becenev</th>
						<th>Kor</th>
						<th>fizetes</th>
						<th>Fokozat</th>
					</tr>
					<xsl:for-each select="class/student">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td style="color:green">
								<xsl:value-of select="vezeteknev" />
							</td>
							<td style="color:brown">
								<xsl:value-of select="keresztnev" />
							</td>
							<td style="color:blue">
								<xsl:value-of select="becenev" />
							</td>
							<td style="color:red">
								<xsl:value-of select="kor" />
							</td>
							<td>
								<xsl:value-of select="fizetes" />
							</td>
							<td>
								<xsl:value-of select="fokozat" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
				<p1>id</p1>
				<p1>Keresztnev</p1>
				<p1>Vezetéknév</p1>
				<p1>Becenév</p1>
				<p1>Kor</p1>
				<p1>fokozat</p1>

				<xsl:for-each select="class/student">
					<br></br>
					<xsl:value-of select="@id" />
					<xsl:value-of select="keresztnev" />
					<xsl:value-of select="vezeteknev" />
					<xsl:value-of select="becenev" />
					<xsl:value-of select="kor" />
					<xsl:value-of select="fizetes" />
					<xsl:value-of select="fokozat" />


				</xsl:for-each>

				<xsl:for-each select="class/student">
					<table border="1">
						<tr bgcolor="#9acd32">
							<th>keresztnev</th>
							<th>fokozat</th>
						</tr>

					</table>
				</xsl:for-each>

				<table border="2">
					<tr bgcolor="green">
						<th>id</th>
						<th>Keresztnev</th>
						<th>Vezeteknev</th>
						<th>Becenev</th>
						<th>Kor</th>
						<th>fizetes</th>
						<th>Fokozat</th>
					</tr>
					<xsl:for-each select="class/student">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td style="color:green">
								<xsl:value-of select="vezeteknev" />
							</td>
							<td style="color:brown">
								<xsl:value-of select="keresztnev" />
							</td>
							<td style="color:blue">
								<xsl:value-of select="becenev" />
							</td>
							<td style="color:red">
								<xsl:value-of select="kor" />
							</td>
							<td>
								<xsl:value-of select="fizetes" />
								<xsl:choose>
									<xsl:when test="fizetes &gt; 19">
										<td bgcolor="#ff00ff">
											<xsl:value-of select="fizetes" />
										</td>
									</xsl:when>
									<xsl:when test="price &gt; 59">
										<td bgcolor="#cccccc">
											<xsl:value-of select="fizetes" />
										</td>
									</xsl:when>
									<xsl:otherwise>
										<td>
											<xsl:value-of select="fizetes" />
										</td>
									</xsl:otherwise>
								</xsl:choose>

							</td>
							<td>
								<xsl:value-of select="fokozat" />
							</td>
						</tr>
					</xsl:for-each>
				</table>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>