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
									<xsl:text>Cotizacion Equipo Electrico</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Equipos Fijos: </xsl:text>
								<xsl:value-of select="documento/equiposFijos" />
								<br />
								<xsl:text>Equipos Port&#225;tiles: </xsl:text>
								<xsl:value-of select="documento/equiposPortatiles" />
								<br />
								<xsl:text>Celulares: </xsl:text>
								<xsl:value-of select="documento/celulares" />
								<br />
								<xsl:text>Tasa Otros: </xsl:text>
								<xsl:value-of select="documento/tasaOtros" />
								<br />
								<xsl:text>Portadores externos de Datos: </xsl:text>
								<xsl:value-of select="documento/portadoresExternosDatos" />
								<br />
								<xsl:text>Incremento en costos de operaci&#237;n: </xsl:text>
								<xsl:value-of select="documento/incrementoCostosOperacion" />
								<br />
								<xsl:text>Hurto: </xsl:text>
								<xsl:value-of select="documento/hurto" />

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
													<xsl:text> OBJETO ASEGURADO </xsl:text>
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
													<xsl:value-of select="objetoAsegurado" />
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
													<xsl:text> CLAUSULAS ADICIONALES </xsl:text>
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
													<xsl:value-of select="clausulasAdicionales" />
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
													<xsl:text> COBERTURAS ADICIONALES </xsl:text>
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
													<xsl:value-of select="coberturasAddicionales" />
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
													<xsl:text> GARANTIA DE LA P&#211;LIZA </xsl:text>
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
													<xsl:value-of select="garantiaPoliza" />
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