package map

import java.util.UUID

import play.api.libs.json.Json
import play.extras.geojson.{GeoJson, LatLng}

case class MapGeometry(uuid: String = UUID.randomUUID().toString,
                       callbackUrl: String,
                       ecosystem: String,
                       changedLayers: IndexedSeq[String],
                       geometry: GeoJson[LatLng])

object MapGeometry {
  private implicit val mapGeometryFormat = Json.format[MapGeometry]
  private implicit val mapGeometryRead = Json.reads[MapGeometry]
  private implicit val mapGeometryWrite = Json.writes[MapGeometry]

  def toJson(geometry: MapGeometry): String = Json.toJson(geometry).toString

  def toMapGeometry(json: String): MapGeometry = Json.parse(json).as[MapGeometry]
}

case class MapGeometryValidation(uuid: String,
                                 callbackUrl: String,
                                 ecosystem: String,
                                 changedLayers: IndexedSeq[String],
                                 geometry: GeoJson[LatLng],
                                 childIds: IndexedSeq[String] = IndexedSeq.empty[String],
                                 parentId: Option[String] = None,
                                 layerDescriptors: Option[Map[String, String]] = None,
                                 isValidationComplete: Boolean = false)

object MapGeometryValidation {
  private implicit val mapGeometryValidationFormat = Json.format[MapGeometryValidation]
  private implicit val mapGeometryValidationRead = Json.reads[MapGeometryValidation]
  private implicit val mapGeometryValidationWrite = Json.writes[MapGeometryValidation]

  def toJson(geometry: MapGeometryValidation): String = Json.toJson(geometry).toString

  def toMapGeometryValidation(json: String): MapGeometryValidation = Json.parse(json).as[MapGeometryValidation]

  def defaultInstance(geometry: MapGeometry): MapGeometryValidation = {
    MapGeometryValidation(geometry.uuid,
      geometry.callbackUrl,
      geometry.ecosystem,
      geometry.changedLayers,
      geometry.geometry)
  }

  def newInstance(geometry: MapGeometry,
                  childIds: IndexedSeq[String],
                  parentId: Option[String],
                  layerDescriptors: Option[Map[String, String]],
                  isValidationComplete: Boolean): MapGeometryValidation = {
    MapGeometryValidation(geometry.uuid,
      geometry.callbackUrl,
      geometry.ecosystem,
      geometry.changedLayers,
      geometry.geometry,
      childIds,
      parentId,
      layerDescriptors,
      isValidationComplete)
  }
}