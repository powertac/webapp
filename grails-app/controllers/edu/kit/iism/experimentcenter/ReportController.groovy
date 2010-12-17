package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.StockType

class ReportController {

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    
  }

}
