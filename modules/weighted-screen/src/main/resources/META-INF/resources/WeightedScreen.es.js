import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import Soy from 'metal-soy/src/Soy';
import templates from './WeightedScreen.soy';

import * as d3 from 'd3';

class WeightedScreen extends Component {

	constructor(opt_config) {
		super(opt_config);

		this.createNodes_();
		this.createScreen_();

	}

	createScreen_() {
		let colors = d3.scaleOrdinal()
	    .range(
	        d3.schemeCategory10.map(
	            (c) => {
	                c = d3.rgb(c);
	                c.opacity = 0.6;

	                return c;
	            }
	        )
	    );

        let root = d3.hierarchy(this.nodesRoot);

        root.sum(
            function(d) {
                return d.views;
            }
        );

        let sizes = this.getParentSizes();

        let treemap = d3.treemap()
            .size(
                [sizes.width, sizes.height]
            )
            .padding(2).paddingInner(15);

        treemap(root);

        let node = d3.select('#weightedScreen').html('');

        node.selectAll('.node')
            .data(
                root.leaves()
            )
            .enter()
            .append('div')
            .attr('class', 'node')
            .attr('title',
                function(d) {
                    return d.id;
                }
            )
            .style('left',
                function(d) {
                    return d.x0 + 'px';
                }
            )
            .style('top',
                function(d) {
                    return d.y0 + 'px';
                })
            .style('width',
                function(d) {
                    return d.x1 - d.x0 + 'px';
                })
            .style('height',
                function(d) {
                    return d.y1 - d.y0 + 'px';
                })
            .style('line-height',
                function(d) {
                    return d.y1 - d.y0 + 'px';
                })
            .style('text-align', 'center')
            .style('background',
                function(d, i) {
                    return colors(i);
                })
            .append('div')
            .attr('class', 'node-label')
            .style('height',
                function(d) {
                    return d.y1 - d.y0 + 'px';
                })
            .style('width',
            function(d) {
                return d.x1 - d.x0 + 'px';
                })
            .style('line-height', 'inherit')
            .append('a')
            .attr('href',
                function(d) {
                    return d.data.url;
                }
            )
            .text(
                function(d) {
                    return d.data.name;
                }
            );

        d3.selectAll('.node')
            .on('mouseover',
                function() {
                    d3.select(this).style('box-shadow', '3px 0px 30px #fff');
                }
            );

        d3.selectAll('.node')
            .on('mouseout',
                function() {
                    d3.select(this).style('box-shadow', 'none');
                }
            );

    }

    createNodes_() {
        this.nodesRoot = {
            'children': [
                { "id": 3, "name": "A Day in the Life of a Product Owner", "views": 148, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/A+Day+in+the+Life+of+a+Product+Owner" },
                { "id": 4, "name": "Advanced System Architecture", "views": 121, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Advanced+System+Architecture" },
                { "id": 5, "name": "Annotations in Liferay portal", "views": 114, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Annotations+in+Liferay+portal" },
                { "id": 6, "name": "Basic cluster config", "views": 141, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Basic+cluster+config" },
                { "id": 7, "name": "Cloud DB", "views": 155, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Cloud+DB" },
                { "id": 2, "name": "Clustering Basics", "views": 147, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Clustering+Basics" },
                { "id": 8, "name": "Company Meeting Q video collection", "views": 174, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Company+Meeting+Q+video+collection" },
                { "id": 9, "name": "CS & TS workflow", "views": 177, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/CS+&+TS+workflow" },
                { "id": 10, "name": "Data Dialogs 2016", "views": 185, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Data+Dialogs+2016" },
                { "id": 11, "name": "Eclipse Hot Keys", "views": 541, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Eclipse+Hot+Keys" }
            ]
        };
    }

}

// Register component
Soy.register(WeightedScreen, templates);

WeightedScreen.STATE = {
	handicap: {
		value: 50
	},

	nodesNumber: {
		value: 10
	},

    nodesRoot: {
    },

	shuffled: {
		value: true
	}
}

export default WeightedScreen;