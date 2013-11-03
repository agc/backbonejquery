var ride = {
      make: 'Yamaha',
      model: 'V-Star Silverado 1101',
      year: 2005,
      purchased: new Date(2005,3,12),
      owner: {name: 'Spike Spiegel',occupation: 'bounty hunter'},
      whatAmI: function() {
        return this.year+' '+this.make+' '+this.model;
      }
    };
var bike=ride.whatAmI();
alert(bike);


var o1 = {donde:'objeto 1'};
var o2 = {donde:'objeto 2'};
var o3 = {donde:'objeto 3'};

window.donde = 'window';

function dondeEstoy() {
      return this.donde;
}

o1.localizame = dondeEstoy;

alert(dondeEstoy());
alert(o1.localizame());
alert(dondeEstoy.call(o2));
alert(dondeEstoy.apply(o3));
alert(o1.localizame.call(o3));