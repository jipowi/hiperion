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
									<xsl:text>Cotizaci&#243;n Lucro Cesante Rotura Maquinaria </xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Utilidad bruta estimada anual: </xsl:text>
								<xsl:value-of select="documento/utilidadBrutaEstimadaAnual" />
								<br />
								<xsl:text>Tasa: </xsl:text>
								<xsl:value-of select="documento/periodoIndemnizacion" />
								<br />
								<xsl:text>Perido de Indemnizaci&#243;n: </xsl:text>
								<xsl:value-of select="documento/tasa" />
								<br />

							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COBERTURAS </xsl:text>
												</h3>
											</td>
										</tr>
									</tbody>

								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/coberturas">
											<tr>
												<td>
													<xsl:value-of select="coberturas" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> CLAUSULAS ADDICIONALES </xsl:text>
												</h3>
											</td>
										</tr>
									</tbody>

								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/clausulasAdicionales">
											<tr>
												<td>
													<xsl:value-of select="clausulasAdicionales" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
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