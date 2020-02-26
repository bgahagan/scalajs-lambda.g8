import scalajs.js
import js.annotation.JSExportTopLevel
import net.exoego.facade.aws_lambda._
import scala.concurrent.{Future, ExecutionContext}

object Handler {

  def main(event: APIGatewayProxyEvent)(implicit ec: ExecutionContext): Future[APIGatewayProxyResult] = Future {
    APIGatewayProxyResult(
      statusCode = 200,
      body = "hello " + event.body, 
      headers = js.defined(js.Dictionary("Content-Type" -> "text/plain"))
    )
  }

  @JSExportTopLevel(name="handler")
  val handler: js.Function2[APIGatewayProxyEvent, Context, js.Promise[APIGatewayProxyResult]] = { 
    (event: APIGatewayProxyEvent, _: Context) =>
      import js.JSConverters._
      implicit val ec = ExecutionContext.global
      main(event).toJSPromise
  }

}
