package edu.kit.iism.experimentcenter

import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.CompareToBuilder
import edu.kit.iism.experimentcenter.enumerations.ShoutType
import edu.kit.iism.experimentcenter.enumerations.ShoutStatus

class Shout implements Comparable, Serializable {

  public static final maxPrice = 3000.0d

  String id
  Experiment experiment
  TradingAgent tradingAgent
  Timeslot timeslot
  BlockShout blockShout
  ShoutType shoutType                         //either Bid or Ask
  ShoutStatus shoutStatus = ShoutStatus.Open  //indicates wether the shout is open, cancelled or matched
  Double quantity;                            //Amount of Electricity to acquire
  Double limitPrice                           //min / max willingness to pay per bundle
  Double quantityAlloc                        //the effectively allocated number of bundles -> value set by the auctionService
  Double priceAlloc                           //the matching price per bundle -> value set by the auctionService
  Long transactionId
  Date dateClosed
  Date dateCreated = new Date()
  Date validUntil = new Date() + 1
  String comment

  static belongsTo = [timeslot: Timeslot, tradingAgent: TradingAgent, blockShout: BlockShout, experiment: Experiment]

  static constraints = {
    experiment(nullable: false)
    tradingAgent(nullable: false)
    timeslot(nullable: false)
    blockShout(nullable: true)
    shoutType(nullable: false)
    shoutStatus(nullable: false)
    quantity(nullable: false, min: 0d)
    limitPrice(nullable: false, range: 0.0d..maxPrice)
    quantityAlloc(nullable: true, min: 0d)
    priceAlloc(nullable: true, min: 0d)
    transactionId(nullable: true)
    dateClosed(nullable: true)
    dateCreated(nullable: false)
    validUntil(nullable: true)
    comment(nullable: true)
  }

  static mapping = {
    id generator: 'assigned'
    experiment(index: 'shout_exp_idx, shout_exp_ta_idx, shout_exp_ta_ts_idx')
    tradingAgent(index: 'shout_ta_idx, shout_exp_ta_idx, shout_exp_ta_ts_idx')
    timeslot(index: 'shout_ts_idx, shout_exp_ta_ts_idx')
  }

  /** ******************
   *  Business Logic
   ********************
   */
  public String toString() {
    return "${shoutType} ${quantity} @ ${limitPrice}EUR in timeslot ${timeslot} (by ${tradingAgent})"
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 37).
        append(this.id).
        toHashCode();
  }

  public boolean equals(Object o) {
    if (!o instanceof Shout) return false
    Shout other = (Shout) o
    return new EqualsBuilder().append(this?.id, other?.id).isEquals()
  }

  public int compareTo(Object o) {
    if (!o instanceof Shout) return 1
    Shout other = (Shout) o
    return new CompareToBuilder().append(this?.id, other?.id).toComparison();
  }
}
