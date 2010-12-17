import edu.kit.iism.experimentcenter.*

class UrlMappings {
  static mappings = {
    "/rest/$controller/$id?" (parseRequest: true) {
      action =[GET: "get", POST: "add", PUT: "change", DELETE: "remove"]
    }

    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }
    "/"(view: "/index")
    "500"(view: '/error')
  }
}
