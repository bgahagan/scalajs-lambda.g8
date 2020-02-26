import scalajs.js
import js.annotation.JSExportTopLevel
import js.JSConverters._
import net.exoego.facade.aws_lambda._
import scala.concurrent.{Future, ExecutionContext}

object Handler {

  def main(event: APIGatewayEvent)(implicit ec: ExecutionContext): Future[APIGatewayProxyResult] = Future {
    APIGatewayProxyResult(
      statusCode = 200,
      body = "hello " + event.body, 
      headers = js.defined(js.Dictionary("Content-Type" -> "text/plain"))
    )
  }

  @JSExportTopLevel(name="handler")
  val handler: APIGatewayProxyHandler = {
    (event: APIGatewayEvent, ctx: Context, _: Callback[ProxyResult]) =>
      implicit val ec = ExecutionContext.global
      main(event).toJSPromise
  }

}
