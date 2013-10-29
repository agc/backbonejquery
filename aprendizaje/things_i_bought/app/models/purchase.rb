class Purchase < ActiveRecord::Base
  validates :name, presence: true
  validates :cost, numericality: { greather_than: 0}
end
