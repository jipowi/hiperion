<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<center>
				<table width="100%" cellpadding="0" cellspacing="5" border="0">
					<col style="width:80%;" />
					<tbody>
						<tr>
							<td align="center" colspan="2" style="font-weight: bold;">
								<h3>
									<xsl:text>Cotizaci&#243;n Robo y/o Asalto </xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Tasa Robo y/o Asalto: </xsl:text>
								<xsl:value-of select="documento/tasaRoboAsalto" />
								<br />
								<xsl:text>Tasa Hurto: </xsl:text>
								<xsl:value-of select="documento/tasaHurto" />
								<br />
								<xsl:text>Tasa Propiedad de Empleados: </xsl:text>
								<xsl:value-of select="documento/tasaPropiedadEmpleados" />
								<br />
								<xsl:text>Tasa Contenidos: </xsl:text>
								<xsl:value-of select="documento/tasaContenidos" />
								<br />
							</td>
						</tr>
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
					</tbody>
				</table>

			</center>
		</html>
	</xsl:template>
</xsl:stylesheet>