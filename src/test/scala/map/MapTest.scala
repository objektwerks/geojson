package map

import org.scalatest.FunSuite
import org.slf4j.{Logger, LoggerFactory}

import scala.io.Source

class MapTest extends FunSuite {
  val log: Logger = LoggerFactory.getLogger(this.getClass)

  val geometryJson = Source.fromInputStream(getClass.getResourceAsStream("/map.geometry.json")).mkString
  val validationJson = Source.fromInputStream(getClass.getResourceAsStream("/map.geometry.validation.json")).mkString

  test("map geometry") {
    val geometry = MapGeometry.toMapGeometry(geometryJson)
    log.debug(MapGeometry.toJson(geometry))
  }

  test("map geometry validation") {
    val validation = MapGeometryValidation.toMapGeometryValidation(validationJson)
    log.debug(MapGeometryValidation.toJson(validation))
  }
}
